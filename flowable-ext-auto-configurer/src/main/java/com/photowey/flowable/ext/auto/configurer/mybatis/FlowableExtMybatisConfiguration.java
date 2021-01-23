/*
 * Copyright © 2020 photowey (photowey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.photowey.flowable.ext.auto.configurer.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.photowey.flowable.ext.auto.configurer.property.FlowableExtProperties;
import com.photowey.flowable.ext.mybatis.api.candidate.MybatisCandidate;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.function.Consumer;

import static com.photowey.flowable.ext.auto.configurer.constant.AutoConfigurerConstants.*;

/**
 * {@code FlowableExtMybatisAutoConfiguration}
 *
 * @author photowey
 * @date 2021/01/18
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass(MybatisCandidate.class)
public class FlowableExtMybatisConfiguration implements ResourceLoaderAware, BeanFactoryAware, InitializingBean {

    private ResourceLoader resourceLoader;
    private ListableBeanFactory beanFactory;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ListableBeanFactory) beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        FlowableExtProperties flowableExtProperties = this.beanFactory.getBean(FlowableExtProperties.class);
        if (ObjectUtils.isEmpty(flowableExtProperties.getMapper().getBasePackage())) {
            throw new NullPointerException("the flowable-ext config-key:[flowable.ext.mapper.base-package] can't be blank.");
        }
    }

    /**
     * {@link SqlSessionFactory}
     *
     * @return {@link SqlSessionFactory}
     * @throws Exception
     */
    @Bean(FLOWABLE_EXT_SQL_SESSION_FACTORY_ID)
    @ConditionalOnMissingBean(SqlSessionFactory.class)
    public SqlSessionFactory sqlSessionFactory(ObjectProvider<DataSource> dataSourceProvider) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setVfs(SpringBootVFS.class);
        this.populateDataSource(factoryBean, dataSourceProvider);
        this.populateConfiguration(factoryBean);
        this.populateGlobalConfig(factoryBean);
        this.populateMapperLocations(factoryBean);
        this.populateCandidateBeanType();

        return factoryBean.getObject();
    }

    /**
     * {@link SqlSessionTemplate}
     *
     * @param sqlSessionFactory {@link SqlSessionFactory}
     * @return {@link SqlSessionTemplate}
     */
    @Bean(FLOWABLE_EXT_SQL_SESSION_TEMPLATE_ID_ID)
    @ConditionalOnMissingBean(SqlSessionTemplate.class)
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier(FLOWABLE_EXT_SQL_SESSION_FACTORY_ID) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * {@link TransactionTemplate}
     *
     * @param transactionManager {@link PlatformTransactionManager}
     * @return {@link TransactionTemplate}
     */
    @Bean(FLOWABLE_EXT_TRANSACTION_TEMPLATE_ID)
    @ConditionalOnMissingBean(TransactionTemplate.class)
    public TransactionTemplate transactionTemplate(
            @Qualifier(FLOWABLE_EXT_PLATFORM_TRANSACTION_MANAGER_NAME) PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }

    /**
     * {@link MybatisPlusInterceptor}
     *
     * @return {@link MybatisPlusInterceptor}
     */
    @Bean
    @ConditionalOnMissingBean(MybatisPlusInterceptor.class)
    public MybatisPlusInterceptor paginationInnerInterceptor(SqlSessionFactory sqlSessionFactory) {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // default: MYSQL
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInterceptor);
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.addInterceptor(mybatisPlusInterceptor);

        return mybatisPlusInterceptor;
    }

    /**
     * {@link MapperScannerConfigurer}
     * <p>
     * {@literal @}MapperScan("com.photowey.flowable.ext.mybatis.api.mapper")
     *
     * @return {@link MapperScannerConfigurer}
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        FlowableExtProperties flowableExtProperties = this.beanFactory.getBean(FlowableExtProperties.class);
        // com.xxx.mapper,com.yyy.mapper
        mapperScannerConfigurer.setBasePackage(flowableExtProperties.getMapper().getBasePackage());
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(FLOWABLE_EXT_SQL_SESSION_FACTORY_ID);
        mapperScannerConfigurer.setSqlSessionTemplateBeanName(FLOWABLE_EXT_SQL_SESSION_TEMPLATE_ID_ID);
        return mapperScannerConfigurer;
    }

    private void populateCandidateBeanType() {
        MybatisPlusProperties mybatisPlusProperties = this.beanFactory.getBean(MybatisPlusProperties.class);
        GlobalConfig globalConfig = mybatisPlusProperties.getGlobalConfig();
        globalConfig.setBanner(false);
        this.getBeanThen(MetaObjectHandler.class, globalConfig::setMetaObjectHandler);
        this.getBeanThen(IKeyGenerator.class, i -> globalConfig.getDbConfig().setKeyGenerator(i));
        this.getBeanThen(ISqlInjector.class, globalConfig::setSqlInjector);
        this.getBeanThen(IdentifierGenerator.class, globalConfig::setIdentifierGenerator);
    }

    // -------------------------------------------------------------------------------------------------------------------------- DATA_SOURCE

    private void populateDataSource(MybatisSqlSessionFactoryBean factoryBean, ObjectProvider<DataSource> dataSourceProvider) {
        factoryBean.setDataSource(dataSourceProvider.getObject());
    }

    // -------------------------------------------------------------------------------------------------------------------------- POPULATE

    private void populateGlobalConfig(MybatisSqlSessionFactoryBean factoryBean) {
        MybatisPlusProperties mybatisPlusProperties = this.beanFactory.getBean(MybatisPlusProperties.class);
        GlobalConfig globalConfig = mybatisPlusProperties.getGlobalConfig();
        factoryBean.setGlobalConfig(globalConfig);
    }

    private void populateConfiguration(MybatisSqlSessionFactoryBean factoryBean) {
        MybatisPlusProperties mybatisPlusProperties = this.beanFactory.getBean(MybatisPlusProperties.class);
        MybatisConfiguration configuration = mybatisPlusProperties.getConfiguration();
        if (mybatisPlusProperties.getConfigurationProperties() != null) {
            factoryBean.setConfigurationProperties(mybatisPlusProperties.getConfigurationProperties());
        }
        if (StringUtils.hasText(mybatisPlusProperties.getConfigLocation())) {
            factoryBean.setConfigLocation(this.resourceLoader.getResource(mybatisPlusProperties.getConfigLocation()));
        }
        if (configuration == null && !StringUtils.hasText(mybatisPlusProperties.getConfigLocation())) {
            configuration = new MybatisConfiguration();
        }
        this.applyConfiguration(factoryBean, configuration);
    }

    private void applyConfiguration(MybatisSqlSessionFactoryBean factoryBean, MybatisConfiguration configuration) {
        factoryBean.setConfiguration(configuration);
    }

    private void populateMapperLocations(MybatisSqlSessionFactoryBean factoryBean) {
        MybatisPlusProperties mybatisPlusProperties = this.beanFactory.getBean(MybatisPlusProperties.class);
        Resource[] mapperLocations = mybatisPlusProperties.resolveMapperLocations();
        if (!ObjectUtils.isEmpty(mapperLocations)) {
            factoryBean.setMapperLocations(mapperLocations);
        }
    }

    private <T> void getBeanThen(Class<T> clazz, Consumer<T> consumer) {
        if (this.beanFactory.getBeanNamesForType(clazz, false, false).length > 0) {
            consumer.accept(this.beanFactory.getBean(clazz));
        }
    }
}
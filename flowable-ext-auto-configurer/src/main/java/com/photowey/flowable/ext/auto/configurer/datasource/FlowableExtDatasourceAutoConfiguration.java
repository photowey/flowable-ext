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

package com.photowey.flowable.ext.auto.configurer.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

import static com.photowey.flowable.ext.auto.configurer.datasource.FlowableExtDatasourceAutoConfiguration.FLOWABLE_EXT_DATASOURCE_URL_PREFIX;

/**
 * {@code FlowableExtDatasourceAutoConfiguration}
 *
 * @author photowey
 * @date 2021/01/18
 * @since 1.0.0
 */
@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@ConditionalOnProperty(
        value = {FLOWABLE_EXT_DATASOURCE_URL_PREFIX},
        matchIfMissing = false
)
public class FlowableExtDatasourceAutoConfiguration {

    public static final String FLOWABLE_EXT_DATASOURCE_URL_PREFIX = "spring.datasource.flowable.ext.url";
    private static final String FLOWABLE_EXT_DATASOURCE_TYPE_PREFIX = "spring.datasource.flowable.ext.type";
    private static final String FLOWABLE_EXT_DATASOURCE_DRUID_SOURCE = "spring.datasource.flowable.ext.druid";
    private static final String FLOWABLE_EXT_DATASOURCE_HIKARI_SOURCE = "spring.datasource.flowable.ext.hikari";
    private static final String FLOWABLE_EXT_DATASOURCE_NAME = "flowable-ext-datasource";
    private static final String FLOWABLE_EXT_PLATFORM_TRANSACTION_MANAGER_NAME = "flowable-ext-datasource";

    private static final String DRUID_DATA_SOURCE = "com.alibaba.druid.pool.DruidDataSource";
    private static final String HIKARICP_DATA_SOURCE = "com.zaxxer.hikari.HikariDataSource";

    /**
     * Create {@link PlatformTransactionManager} instance.
     *
     * @param flowableExtDatasource
     * @return {@link PlatformTransactionManager}
     */
    @Bean(FLOWABLE_EXT_PLATFORM_TRANSACTION_MANAGER_NAME)
    public PlatformTransactionManager flowableExtPlatformTransactionManager(
            @Qualifier(FLOWABLE_EXT_PLATFORM_TRANSACTION_MANAGER_NAME) DataSource flowableExtDatasource) {
        return new DataSourceTransactionManager(flowableExtDatasource);
    }

    /**
     * Create {@link HikariDataSource} instance by default.
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass({HikariDataSource.class})
    @ConditionalOnMissingBean({DataSource.class})
    @ConditionalOnProperty(
            value = {FLOWABLE_EXT_DATASOURCE_TYPE_PREFIX},
            havingValue = HIKARICP_DATA_SOURCE,
            matchIfMissing = true
    )
    static class HikariDatasourceAutoConfiguration {

        /**
         * Create {@link DataSource} instance.
         *
         * @return {@link HikariDataSource}
         */
        @Bean(FLOWABLE_EXT_DATASOURCE_NAME)
        @ConfigurationProperties(FLOWABLE_EXT_DATASOURCE_HIKARI_SOURCE)
        public HikariDataSource dataSource(DataSourceProperties properties) {
            HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder.create().build();
            if (StringUtils.hasText(properties.getName())) {
                dataSource.setPoolName(properties.getName());
            }

            return dataSource;
        }
    }

    /**
     * Create {@link DruidDataSource} instance if necessary.
     */
    @Configuration
    @ConditionalOnClass(DruidDataSource.class)
    @ConditionalOnProperty(
            value = {FLOWABLE_EXT_DATASOURCE_TYPE_PREFIX},
            havingValue = DRUID_DATA_SOURCE,
            matchIfMissing = true
    )
    static class DruidDatasourceAutoConfiguration {

        /**
         * Create {@link DataSource}
         *
         * @return {@link DruidDataSource}
         */
        @Bean(FLOWABLE_EXT_DATASOURCE_NAME)
        @ConfigurationProperties(FLOWABLE_EXT_DATASOURCE_DRUID_SOURCE)
        public DataSource flowableExtDatasource() {
            return DruidDataSourceBuilder.create().build();
        }
    }
}

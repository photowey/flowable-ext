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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

import static com.photowey.flowable.ext.auto.configurer.constant.AutoConfigurerConstants.*;

/**
 * {@code FlowableExtDatasourceAutoConfiguration}
 *
 * @author photowey
 * @date 2021/01/18
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(
        value = {FLOWABLE_EXT_DATASOURCE_CANDIDATE_TYPE_PREFIX},
        matchIfMissing = false
)
@Import(value = {
        FlowableExtDatasourceAutoConfiguration.HikariDatasourceAutoConfiguration.class,
        FlowableExtDatasourceAutoConfiguration.DruidDatasourceAutoConfiguration.class,
})
public class FlowableExtDatasourceAutoConfiguration implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(FlowableExtDatasourceAutoConfiguration.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("activated the flowable-ext auto-configuration");
    }

    /**
     * Create {@link HikariDataSource} instance by default.
     */
    @Configuration
    @ConditionalOnClass({HikariDataSource.class})
    @ConditionalOnMissingBean({DataSource.class})
    @ConditionalOnProperty(
            value = {FLOWABLE_EXT_DATASOURCE_TYPE_PREFIX},
            havingValue = HIKARICP_DATA_SOURCE,
            matchIfMissing = false
    )
    static class HikariDatasourceAutoConfiguration {

        /**
         * Create {@link DataSource} instance.
         *
         * @return {@link HikariDataSource}
         */
        @Bean(FLOWABLE_EXT_DATASOURCE_NAME)
        @ConfigurationProperties(FLOWABLE_EXT_DATASOURCE_HIKARI_SOURCE)
        public DataSource hikariDataSource() {
            log.info("the flowable-ext activated the default hikari-dataSource");
            HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder.create().build();
            dataSource.setPoolName("hikari-data-source");

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
            matchIfMissing = false
    )
    static class DruidDatasourceAutoConfiguration {

        /**
         * Create {@link DataSource}
         *
         * @return {@link DruidDataSource}
         */
        @Bean(FLOWABLE_EXT_DATASOURCE_NAME)
        @ConfigurationProperties(FLOWABLE_EXT_DATASOURCE_DRUID_SOURCE)
        public DataSource druidDataSource() {
            log.info("the flowable-ext activated the user-config druid-dataSource");
            return DruidDataSourceBuilder.create().build();
        }
    }
}

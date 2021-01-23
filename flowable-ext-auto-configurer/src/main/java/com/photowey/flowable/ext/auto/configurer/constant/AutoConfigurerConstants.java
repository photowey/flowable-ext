/*
 * Copyright © 2020-2021 photowey (photowey@gmail.com)
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

package com.photowey.flowable.ext.auto.configurer.constant;

/**
 * {@code AutoConfigurerConstants}
 *
 * @author photowey
 * @date 2021/01/22
 * @since 1.0.0
 */
public interface AutoConfigurerConstants {

    String FLOWABLE_EXT_DATASOURCE_CANDIDATE_TYPE_PREFIX = "spring.datasource.flowable.ext.type";
    String FLOWABLE_EXT_PLATFORM_TRANSACTION_MANAGER_NAME = "flowable-ext-platform-transaction-manager";

    String FLOWABLE_EXT_DATASOURCE_TYPE_PREFIX = "spring.datasource.flowable.ext.type";
    String FLOWABLE_EXT_DATASOURCE_DRUID_SOURCE = "spring.datasource.flowable.ext.druid";
    String FLOWABLE_EXT_DATASOURCE_HIKARI_SOURCE = "spring.datasource.flowable.ext.hikari";
    String FLOWABLE_EXT_DATASOURCE_NAME = "flowable-ext-datasource";

    String DRUID_DATA_SOURCE = "com.alibaba.druid.pool.DruidDataSource";
    String HIKARICP_DATA_SOURCE = "com.zaxxer.hikari.HikariDataSource";

    String FLOWABLE_EXT_SQL_SESSION_FACTORY_ID = "flowable-ext-mybatis-factory";
    String FLOWABLE_EXT_SQL_SESSION_TEMPLATE_ID_ID = "flowable-ext-mybatis-sql-session-template";
    String FLOWABLE_EXT_TRANSACTION_TEMPLATE_ID = "flowable-ext-transaction-template";
}

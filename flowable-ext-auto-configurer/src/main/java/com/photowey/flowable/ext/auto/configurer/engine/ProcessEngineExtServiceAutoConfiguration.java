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

package com.photowey.flowable.ext.auto.configurer.engine;

import com.photowe.ext.core.api.engine.ProcessEngineExt;
import com.photowe.ext.core.engine.impl.ProcessEngineExtImpl;
import com.photowey.flowable.ext.auto.configurer.datasource.FlowableExtDatasourceAutoConfiguration;
import com.photowey.flowable.ext.auto.configurer.mybatis.FlowableExtMybatisConfiguration;
import com.photowey.flowable.ext.auto.configurer.property.FlowableExtProperties;
import org.flowable.engine.FormService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.spring.boot.ProcessEngineServicesAutoConfiguration;
import org.flowable.spring.boot.condition.ConditionalOnProcessEngine;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * {@code ProcessEngineExtServiceAutoConfiguration}
 *
 * @author photowey
 * @date 2021/01/18
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProcessEngine
@ConditionalOnClass(value = {ProcessEngine.class, ProcessEngineExt.class})
@AutoConfigureBefore(value = {ProcessEngineServicesAutoConfiguration.class})
@AutoConfigureAfter(value = {FlowableExtDatasourceAutoConfiguration.class})
@EnableConfigurationProperties(FlowableExtProperties.class)
@Import(value = {FlowableExtMybatisConfiguration.class})
public class ProcessEngineExtServiceAutoConfiguration {

    /**
     * Create {@link ProcessEngineExt} instance if necessary.
     *
     * @param processEngineObjectProvider {@link ObjectProvider<ProcessEngine>}
     * @return {@link ProcessEngineExt}
     */
    @Bean
    @ConditionalOnMissingBean(ProcessEngineExt.class)
    public ProcessEngineExt processEngineExt(ObjectProvider<ProcessEngine> processEngineObjectProvider) {
        return new ProcessEngineExtImpl(processEngineObjectProvider.getIfAvailable());
    }

    /**
     * Create {@link FormService} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link FormService}
     */
    @Bean
    @ConditionalOnMissingBean(FormService.class)
    public FormService formServiceByProcessEngine(ProcessEngineExt processEngineExt) {
        return processEngineExt.getFormService();
    }

    /**
     * Create {@link HistoryService} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link HistoryService}
     */
    @Bean
    @ConditionalOnMissingBean(HistoryService.class)
    public HistoryService historyServiceByProcessEngine(ProcessEngineExt processEngineExt) {
        return processEngineExt.getHistoryService();
    }

    /**
     * Create {@link RepositoryService} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link RepositoryService}
     */
    @Bean
    @ConditionalOnMissingBean(RepositoryService.class)
    public RepositoryService repositoryServiceByProcessEngine(ProcessEngineExt processEngineExt) {
        return processEngineExt.getRepositoryService();
    }

    // TODO Other services
}

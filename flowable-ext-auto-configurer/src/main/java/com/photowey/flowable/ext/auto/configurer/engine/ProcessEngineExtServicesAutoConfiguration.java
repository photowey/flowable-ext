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

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.photowey.ext.core.api.engine.ProcessEngineExt;
import com.photowey.ext.core.api.engine.inject.ProcessEngineExtInjector;
import com.photowey.ext.core.dynamic.bpmn.impl.DynamicBpmnServiceExtImpl;
import com.photowey.ext.core.engine.impl.ProcessEngineExtImpl;
import com.photowey.ext.core.engine.inject.ProcessEngineExtExtInjector;
import com.photowey.flowable.ext.auto.configurer.datasource.FlowableExtDatasourceAutoConfiguration;
import com.photowey.flowable.ext.auto.configurer.mybatis.FlowableExtMybatisConfiguration;
import com.photowey.flowable.ext.auto.configurer.property.FlowableExtProperties;
import com.photowey.flowable.ext.mybatis.api.impl.service.impl.NativeQueryServiceImpl;
import com.photowey.flowable.ext.mybatis.api.mapper.NativeQueryMapper;
import com.photowey.flowable.ext.mybatis.api.service.NativeQueryService;
import org.flowable.engine.*;
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
@Import(value = {FlowableExtMybatisConfiguration.class})
@EnableConfigurationProperties(FlowableExtProperties.class)
@ConditionalOnClass(value = {ProcessEngine.class, ProcessEngineExt.class})
@AutoConfigureBefore(value = {ProcessEngineServicesAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@AutoConfigureAfter(value = {FlowableExtDatasourceAutoConfiguration.class})
public class ProcessEngineExtServicesAutoConfiguration {

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
     * Create {@link ProcessEngineExtInjector} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link ProcessEngineExtInjector }
     */
    @Bean
    @ConditionalOnMissingBean(ProcessEngineExtInjector.class)
    public ProcessEngineExtInjector processEngineExtInjector(ProcessEngineExt processEngineExt) {
        return new ProcessEngineExtExtInjector(processEngineExt);
    }

    /**
     * Create {@link DynamicBpmnService} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link DynamicBpmnService }
     */
    @Bean
    @ConditionalOnMissingBean(DynamicBpmnService.class)
    public DynamicBpmnService dynamicBpmnServiceByProcessEngine(ProcessEngineExt processEngineExt) {
        return new DynamicBpmnServiceExtImpl(processEngineExt);
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
     * Create {@link IdentityService} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link IdentityService}
     */
    @Bean
    @ConditionalOnMissingBean(IdentityService.class)
    public IdentityService identityServiceByProcessEngine(ProcessEngineExt processEngineExt) {
        return processEngineExt.getIdentityService();
    }

    /**
     * Create {@link ManagementService} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link ManagementService}
     */
    @Bean
    @ConditionalOnMissingBean(ManagementService.class)
    public ManagementService managementServiceByProcessEngine(ProcessEngineExt processEngineExt) {
        return processEngineExt.getManagementService();
    }

    /**
     * Create {@link ProcessMigrationService} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link ProcessMigrationService}
     */
    @Bean
    @ConditionalOnMissingBean(ProcessMigrationService.class)
    public ProcessMigrationService processMigrationServiceByProcessEngine(ProcessEngineExt processEngineExt) {
        return processEngineExt.getProcessMigrationService();
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

    /**
     * Create {@link RuntimeService} instance if necessary.
     *
     * @param processEngineExt {@link ProcessEngineExt
     * @return {@link RepositoryService}
     */
    @Bean
    @ConditionalOnMissingBean(RuntimeService.class)
    public RuntimeService runtimeServiceByProcessEngine(ProcessEngineExt processEngineExt) {
        return processEngineExt.getRuntimeService();
    }

    /**
     * Create {@link NativeQueryService} instance if necessary.
     *
     * @return {@link NativeQueryService}
     */
    @Bean
    @ConditionalOnMissingBean(NativeQueryService.class)
    public NativeQueryService nativeQueryService(NativeQueryMapper nativeQueryMapper) {
        return new NativeQueryServiceImpl(nativeQueryMapper);
    }

    // TODO
}

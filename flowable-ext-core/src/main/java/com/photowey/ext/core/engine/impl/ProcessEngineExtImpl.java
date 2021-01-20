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

package com.photowey.ext.core.engine.impl;

import com.photowey.ext.core.api.dynamic.DynamicBpmnServiceExt;
import com.photowey.ext.core.api.engine.ProcessEngineExt;
import com.photowey.ext.core.api.form.FormServiceExt;
import com.photowey.ext.core.api.history.HistoryServiceExt;
import com.photowey.ext.core.api.identity.IdentityServiceExt;
import com.photowey.ext.core.api.management.ManagementServiceExt;
import com.photowey.ext.core.api.process.ProcessMigrationServiceExt;
import com.photowey.ext.core.api.repository.RepositoryServiceExt;
import com.photowey.ext.core.api.runtime.RuntimeServiceExt;
import com.photowey.ext.core.api.task.TaskServiceExt;
import com.photowey.flowable.ext.mybatis.api.service.NativeQueryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;

/**
 * {@code ProcessEngineExtImpl} is a class that implements {@link com.photowey.ext.core.api.engine.ProcessEngineExt}
 *
 * @author photowey
 * @date 2020/12/28
 * @since 1.0.0
 */
public class ProcessEngineExtImpl implements ProcessEngineExt {

    /**
     * {@link ProcessEngine}
     */
    private final ProcessEngine processEngine;

    public ProcessEngineExtImpl(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    @Override
    public ProcessEngine getProcessEngine() {
        return this.processEngine;
    }

    @Override
    public void startExecutors() {

    }

    @Override
    public RepositoryServiceExt getRepositoryService() {
        // TODO
        return null;
    }

    @Override
    public RuntimeServiceExt getRuntimeService() {
        // TODO
        return null;
    }

    @Override
    public FormServiceExt getFormService() {
        // TODO
        return null;
    }

    @Override
    public TaskServiceExt getTaskService() {
        // TODO
        return null;
    }

    @Override
    public HistoryServiceExt getHistoryService() {
        // TODO
        return null;
    }

    @Override
    public IdentityServiceExt getIdentityService() {
        // TODO
        return null;
    }

    @Override
    public ManagementServiceExt getManagementService() {
        // TODO
        return null;
    }

    @Override
    public DynamicBpmnServiceExt getDynamicBpmnService() {
        // TODO
        return null;
    }

    @Override
    public ProcessMigrationServiceExt getProcessMigrationService() {
        // TODO
        return null;
    }

    @Override
    public ProcessEngineConfiguration getProcessEngineConfiguration() {
        // TODO
        return null;
    }

    @Override
    public NativeQueryService getNativeQueryService() {
        return null;
    }
}

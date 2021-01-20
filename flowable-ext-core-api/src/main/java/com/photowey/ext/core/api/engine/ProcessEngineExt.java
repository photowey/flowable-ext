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

package com.photowey.ext.core.api.engine;

import com.photowey.ext.core.api.dynamic.DynamicBpmnServiceExt;
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
 * {@code ProcessEngineExt} is an interface that extends(ext) {@link ProcessEngine}
 * provides access to all the ext services that expose the BPM and workflow operations.
 *
 * @author photowey
 * @date 2020/12/28
 * @since 1.0.0
 */
public interface ProcessEngineExt {

    /**
     * {@link ProcessEngine}
     *
     * @return {@link ProcessEngine}
     */
    ProcessEngine getProcessEngine();

    /**
     * The flowable-ext version
     */
    String FLOWABLE_EXT_VERSION = "1.0.0";

    /**
     * start Executors
     */
    void startExecutors();

    /**
     * {@link RepositoryServiceExt}
     *
     * @return {@link RepositoryServiceExt}
     */
    RepositoryServiceExt getRepositoryService();

    /**
     * {@link RuntimeServiceExt}
     *
     * @return {@link RuntimeServiceExt}
     */
    RuntimeServiceExt getRuntimeService();

    /**
     * {@link FormServiceExt}
     *
     * @return {@link FormServiceExt}
     */
    FormServiceExt getFormService();

    /**
     * {@link TaskServiceExt}
     *
     * @return {@link TaskServiceExt}
     */
    TaskServiceExt getTaskService();

    /**
     * {@link HistoryServiceExt}
     *
     * @return {@link HistoryServiceExt}
     */
    HistoryServiceExt getHistoryService();

    /**
     * {@link IdentityServiceExt}
     *
     * @return {@link IdentityServiceExt}
     */
    IdentityServiceExt getIdentityService();

    /**
     * {@link ManagementServiceExt}
     *
     * @return {@link ManagementServiceExt}
     */
    ManagementServiceExt getManagementService();

    /**
     * {@link DynamicBpmnServiceExt}
     *
     * @return {@link DynamicBpmnServiceExt}
     */
    DynamicBpmnServiceExt getDynamicBpmnService();

    /**
     * {@link ProcessMigrationServiceExt}
     *
     * @return {@link ProcessMigrationServiceExt}
     */
    ProcessMigrationServiceExt getProcessMigrationService();

    /**
     * {@link ProcessEngineConfiguration}
     *
     * @return {@link ProcessEngineConfiguration}
     */
    ProcessEngineConfiguration getProcessEngineConfiguration();

    /**
     * {@link NativeQueryService}
     * provides all native query operations.
     *
     * @return {@link NativeQueryService}
     */
    NativeQueryService getNativeQueryService();
}

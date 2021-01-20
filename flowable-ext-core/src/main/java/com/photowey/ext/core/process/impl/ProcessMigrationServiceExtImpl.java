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

package com.photowey.ext.core.process.impl;

import com.photowey.ext.core.api.engine.ProcessEngineExt;
import com.photowey.ext.core.api.process.ProcessMigrationServiceExt;
import com.photowey.ext.core.process.AbstractProcessMigrationServiceDelegate;
import org.flowable.engine.ProcessMigrationService;

/**
 * ProcessMigrationServiceExtImpl
 *
 * @author photowey
 * @date 2021/01/01
 * @since 1.0.0
 */
public class ProcessMigrationServiceExtImpl extends AbstractProcessMigrationServiceDelegate implements ProcessMigrationServiceExt {

    private final ProcessEngineExt processEngineExt;

    public ProcessMigrationServiceExtImpl(ProcessEngineExt processEngineExt) {
        this.processEngineExt = processEngineExt;
    }

    @Override
    public ProcessMigrationService getProcessMigrationService() {
        return this.processEngineExt.getProcessEngine().getProcessMigrationService();
    }
}

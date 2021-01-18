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

package com.photowe.ext.core.history.impl;

import com.photowe.ext.core.api.engine.ProcessEngineExt;
import com.photowe.ext.core.api.history.HistoryServiceExt;
import com.photowe.ext.core.history.AbstractHistoryServiceDelegate;
import org.flowable.engine.HistoryService;

/**
 * HistoryServiceExtImpl
 *
 * @author photowey
 * @date 2021/01/01
 * @since 1.0.0
 */
public class HistoryServiceExtImpl extends AbstractHistoryServiceDelegate implements HistoryServiceExt {

    private final ProcessEngineExt processEngineExt;

    public HistoryServiceExtImpl(ProcessEngineExt processEngineExt) {
        this.processEngineExt = processEngineExt;
    }

    @Override
    public HistoryService getHistoryService() {
        return this.processEngineExt.getProcessEngineConfiguration().getHistoryService();
    }
}

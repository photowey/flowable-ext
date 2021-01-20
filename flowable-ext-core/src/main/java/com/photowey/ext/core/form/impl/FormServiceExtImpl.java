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

package com.photowey.ext.core.form.impl;

import com.photowey.ext.core.api.engine.ProcessEngineExt;
import com.photowey.ext.core.api.form.FormServiceExt;
import com.photowey.ext.core.form.AbstractFormServiceDelegate;
import org.flowable.engine.FormService;

/**
 * FormServiceExtImpl
 *
 * @author photowey
 * @date 2021/01/01
 * @since 1.0.0
 */
public class FormServiceExtImpl extends AbstractFormServiceDelegate implements FormServiceExt {

    private final ProcessEngineExt processEngineExt;

    public FormServiceExtImpl(ProcessEngineExt processEngineExt) {
        this.processEngineExt = processEngineExt;
    }

    @Override
    public FormService getFormService() {
        return this.processEngineExt.getProcessEngineConfiguration().getFormService();
    }
}

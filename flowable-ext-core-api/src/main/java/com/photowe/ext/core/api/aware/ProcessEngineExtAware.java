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

package com.photowe.ext.core.api.aware;

import com.photowe.ext.core.api.engine.ProcessEngineExt;
import org.springframework.beans.factory.Aware;

/**
 * {@code ProcessEngineExtAware} is a marker interface indicating that
 * a bean want to inject the {@link com.photowe.ext.core.api.engine.ProcessEngineExt} instance
 *
 * @author photowey
 * @date 2021/01/03
 * @since 1.0.0
 */
public interface ProcessEngineExtAware extends Aware {

    /**
     * Set {@link ProcessEngineExt} instance
     *
     * @param processEngineExt the ext process engine {@link ProcessEngineExt}
     */
    void setProcessEngineExt(ProcessEngineExt processEngineExt);
}

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

package com.photowe.ext.core.management.impl;

import com.photowe.ext.core.api.management.ManagementServiceExt;
import org.flowable.engine.ManagementService;

/**
 * ManagementServiceExtImpl
 *
 * @author photowey
 * @date 2021/01/01
 * @since 1.0.0
 */
public class ManagementServiceExtImpl implements ManagementServiceExt {

    private final ManagementService managementService;

    public ManagementServiceExtImpl(ManagementService managementService) {
        this.managementService = managementService;
    }
}

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

package com.photowey.flowable.ext.plugin.api.storage;

import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

/**
 * Storage
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
@FunctionalInterface
public interface Storage<T extends AbstractCommandContext> {

    /**
     * Save the business data image, if necessary.
     * If anyone return {@code false}, the current action will be interrupted, and return {@code false}
     *
     * @param context The command context
     * @return {@code boolean}
     */
    boolean save(T context);
}

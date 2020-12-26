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

package com.photowey.flowable.ext.command.cmd;

import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

/**
 * {@code Command} is an interface that can be implemented by objects
 *
 * @param <T> The T type Context
 * @param <R> The command execute result R type
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
@FunctionalInterface
public interface Command<T extends AbstractCommandContext, R> {

    /**
     * Execute the Command with context that extends {@link AbstractCommandContext}.
     *
     * @param context The command context
     * @return The command execute result R type
     */
    R execute(T context);
}

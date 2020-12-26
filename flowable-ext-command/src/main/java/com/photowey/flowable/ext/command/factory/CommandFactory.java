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

package com.photowey.flowable.ext.command.factory;

import com.photowey.flowable.ext.command.cmd.Command;
import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

/**
 * {@code CommandFactory} is an interface that can be implemented by real command factory,
 * that create the real command.
 *
 * @param <T> The context
 * @param <C> The command
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface CommandFactory<T extends AbstractCommandContext, C extends Command<T, ?>> {

    /**
     * Create the context.
     *
     * @return the command context, T type.
     */
    T createContext();

    /**
     * Create the command
     *
     * @return the command, C type
     */
    C createCommand();

}

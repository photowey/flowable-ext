/*
 * Copyright © 2020-2021 photowey (photowey@gmail.com)
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

package com.photowey.ext.core.api.message.context;

import com.photowey.flowable.ext.common.context.Attributes;

import java.util.Properties;

/**
 * {@code MessageContext} is an interface that provide the context of send message in the action of process
 *
 * @author photowey
 * @date 2021/01/03
 * @since 1.0.0
 */
public interface MessageContext extends Attributes {

    /**
     * Get the message context.
     *
     * @return {@link Properties}
     */
    Properties getMessageContext();

}

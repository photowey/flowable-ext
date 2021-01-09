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

package com.photowey.flowable.ext.common.event.bus;

import com.photowey.flowable.ext.common.event.Event;
import com.photowey.flowable.ext.common.event.subscriber.Subscriber;

/**
 * EventBus
 *
 * @author photowey
 * @date 2021/01/09
 * @since 1.0.0
 */
public interface EventBus {

    /**
     * Register the Subscriber
     *
     * @param subscriber {@link Subscriber}
     * @param <T>
     */
    <T extends Subscriber<?, ?>> void register(T subscriber);

    /**
     * Un-register the Subscriber
     *
     * @param subscriber {@link Subscriber}
     * @param <T>
     */
    <T extends Subscriber<?, ?>> void unregister(T subscriber);

    /**
     * Post a Event
     *
     * @param event {@link Event}
     * @param <T>
     */
    <T extends Event<?>> void post(T event);

}

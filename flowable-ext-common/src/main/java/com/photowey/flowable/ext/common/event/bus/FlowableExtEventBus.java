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
import com.photowey.flowable.ext.common.thread.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * FlowableExtEventBus
 *
 * @author photowey
 * @date 2021/01/09
 * @since 1.0.0
 */
public class FlowableExtEventBus implements EventBus {

    /**
     * The constant CORE_HANDLER_THREAD.
     */
    int CORE_HANDLER_THREAD = 1;

    /**
     * The constant MAX_HANDLER_THREAD.
     */
    int MAX_HANDLER_THREAD = 1;

    private static final Logger log = LoggerFactory.getLogger(FlowableExtEventBus.class);

    private final com.google.common.eventbus.EventBus eventBus;

    public FlowableExtEventBus(String identifier) {
        this(identifier, false);
    }

    public FlowableExtEventBus(String identifier, boolean async) {
        if (!async) {
            this.eventBus = new com.google.common.eventbus.EventBus(identifier);
        } else {
            final ExecutorService eventExecutor = new ThreadPoolExecutor(
                    CORE_HANDLER_THREAD,
                    MAX_HANDLER_THREAD,
                    Integer.MAX_VALUE,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(),
                    new NamedThreadFactory(identifier, 1),
                    (r, executor) -> log.warn("eventBus executor queue is full, size:{}", executor.getQueue().size())
            );

            this.eventBus = new com.google.common.eventbus.AsyncEventBus(identifier, eventExecutor);
        }
    }

    @Override
    public <T extends Subscriber<?, ?>> void register(T subscriber) {
        this.eventBus.register(subscriber);
    }

    @Override
    public <T extends Subscriber<?, ?>> void unregister(T subscriber) {
        this.eventBus.unregister(subscriber);
    }

    @Override
    public <T extends Event<?>> void post(T event) {
        this.eventBus.post(event);
    }
}

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

package com.photowey.flowable.ext.common.event.subscriber;

import com.google.common.eventbus.Subscribe;
import com.photowey.flowable.ext.common.event.Event;
import com.photowey.flowable.ext.common.thread.NamedThreadFactory;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * {@code Subscriber} is an interface indicating that a Object is an {@link Subscriber} subscriber
 *
 * @author photowey
 * @date 2021/01/09
 * @since 1.0.0
 */
public interface Subscriber<EVENT extends Event<SOURCE>, SOURCE> {

    /**
     * CORE_HANDLER_THREAD.
     */
    int CORE_HANDLER_THREAD = 1;

    /**
     * MAX_HANDLER_THREAD.
     */
    int MAX_HANDLER_THREAD = 1;

    /**
     * {@link ExecutorService}
     */
    ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(
            CORE_HANDLER_THREAD,
            MAX_HANDLER_THREAD,
            Integer.MAX_VALUE,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),
            new NamedThreadFactory("handle-event", MAX_HANDLER_THREAD)
    );

    /**
     * Execute the task in async
     *
     * @return
     */
    default boolean asyncExecute() {
        return true;
    }

    /**
     * Before event.
     */
    default void beforeEvent() {

    }

    /**
     * Process.
     *
     * @param event the event.
     */
    void handleEvent(EVENT event);

    /**
     * On process event.
     *
     * @param event the event.
     */
    @Subscribe
    default void onProcessEvent(EVENT event) {
        if (this.asyncExecute()) {
            this.getExecutorService().submit(() -> {
                this.syncExecute(event);
            });
        } else {
            this.syncExecute(event);
        }
    }

    /**
     * Execute the task in sync.
     *
     * @param event the event
     */
    default void syncExecute(EVENT event) {
        this.beforeEvent();
        this.handleEvent(event);
        this.afterEvent();
    }

    /**
     * After event.
     */
    default void afterEvent() {

    }

    /**
     * On shut down.
     */
    @PreDestroy
    default void onShutdown() {
        this.getExecutorService().shutdownNow();
    }

    default ExecutorService getExecutorService() {
        return EXECUTOR_SERVICE;
    }
}
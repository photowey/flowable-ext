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

import com.photowey.flowable.ext.common.event.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@code TestSyncSubscriber} is a {@link TestEvent} event subscriber.
 *
 * @author photowey
 * @date 2021/01/09
 * @since 1.0.0
 */
public class TestAsyncSubscriber implements Subscriber<TestEvent, String> {

    private static final Logger log = LoggerFactory.getLogger(TestAsyncSubscriber.class);

    private String eventSource;

    @Override
    public void handleEvent(TestEvent event) {
        this.eventSource = event.getSource();
        log.info("process the TestEvent in {} Subscriber, the event source:[{}]", this.getClass().getSimpleName(), this.eventSource);
    }

    @Override
    public boolean asyncExecute() {
        return true;
    }

    public String getEventSource() {
        return eventSource;
    }
}

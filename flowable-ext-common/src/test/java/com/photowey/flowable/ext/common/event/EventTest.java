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

package com.photowey.flowable.ext.common.event;

import com.photowey.flowable.ext.common.event.bus.EventBus;
import com.photowey.flowable.ext.common.event.bus.FlowableExtEventBus;
import com.photowey.flowable.ext.common.event.subscriber.TestAnotherSubscriber;
import com.photowey.flowable.ext.common.event.subscriber.TestAsyncSubscriber;
import com.photowey.flowable.ext.common.event.subscriber.TestSubscriber;
import com.photowey.flowable.ext.common.sync.Synchronizer;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/**
 * EventTest
 *
 * @author photowey
 * @date 2021/01/09
 * @since 1.0.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventTest {

    static EventBus eventBus;

    @BeforeAll
    public static void init() {
        eventBus = new FlowableExtEventBus("test");
    }

    @AfterAll
    public static void destroy() {
        eventBus = null;
    }

    @Test
    @Order(1)
    public void testHello() {
        Assertions.assertTrue(true);
    }

    @Test
    @Order(2)
    public void testAsync() {
        String testEventSource = "register";
        TestAsyncSubscriber testAsyncSubscriber = new TestAsyncSubscriber();
        eventBus.register(testAsyncSubscriber);

        eventBus.post(new TestEvent(testEventSource));
        Assertions.assertEquals(null, testAsyncSubscriber.getEventSource(), "handle testEvent error");

        eventBus.unregister(testAsyncSubscriber);
        eventBus.post(new TestEvent("unregister"));
        Assertions.assertEquals("register", testAsyncSubscriber.getEventSource(), "handle testEvent error");

        new Synchronizer().sync(2, TimeUnit.SECONDS);
    }

    @Test
    @Order(3)
    public void testAsyncWithPause() {
        String testEventSource = "register";
        TestAsyncSubscriber testAsyncSubscriber = new TestAsyncSubscriber();
        eventBus.register(testAsyncSubscriber);

        eventBus.post(new TestEvent(testEventSource));
        // pause
        new Synchronizer().sync(1, TimeUnit.SECONDS);
        Assertions.assertEquals("register", testAsyncSubscriber.getEventSource(), "handle testEvent error");

        eventBus.unregister(testAsyncSubscriber);
        eventBus.post(new TestEvent("unregister"));
        Assertions.assertEquals("register", testAsyncSubscriber.getEventSource(), "handle testEvent error");

        new Synchronizer().sync(2, TimeUnit.SECONDS);
    }

    @Test
    @Order(4)
    public void testSingleSubscriber() {
        String testEventSource = "register";
        TestSubscriber testSubscriber = new TestSubscriber();
        eventBus.register(testSubscriber);

        eventBus.post(new TestEvent(testEventSource));
        Assertions.assertEquals("register", testSubscriber.getEventSource(), "handle testEvent error");

        eventBus.unregister(testSubscriber);
        eventBus.post(new TestEvent("unregister"));
        Assertions.assertEquals("register", testSubscriber.getEventSource(), "handle testEvent error");

        new Synchronizer().sync(2, TimeUnit.SECONDS);
    }

    @Test
    @Order(5)
    public void testMultiSubscriber() {
        String testEventSource = "register";
        TestSubscriber testSubscriber = new TestSubscriber();
        TestAnotherSubscriber testAnotherSubscriber = new TestAnotherSubscriber();
        eventBus.register(testSubscriber);
        eventBus.register(testAnotherSubscriber);

        eventBus.post(new TestEvent(testEventSource));
        Assertions.assertEquals("register", testSubscriber.getEventSource(), "testSubscriber handle testEvent error");
        Assertions.assertEquals("register", testAnotherSubscriber.getEventSource(), "testAnotherSubscriber handle testEvent error");

        eventBus.unregister(testSubscriber);
        eventBus.post(new TestEvent("unregister"));
        Assertions.assertEquals("register", testSubscriber.getEventSource(), "testSubscriber handle testEvent error");
        Assertions.assertEquals("unregister", testAnotherSubscriber.getEventSource(), "testAnotherSubscriber handle testEvent error");

        new Synchronizer().sync(2, TimeUnit.SECONDS);
    }
}
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

import com.photowey.flowable.ext.command.factory.TestCommandContextFactory;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * CommandContextTest
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommandContextTest {

    private static final Logger log = LoggerFactory.getLogger(CommandContextTest.class);

    @Test
    @Order(1)
    public void testSetAttribute() {
        final String helloKey = "hello";
        final String testKey = "test";
        TestCommandContext commandContext = TestCommandContextFactory.createTestCommandContext();
        commandContext.setAttribute(helloKey, "world");
        commandContext.setAttribute(testKey, "Flowable-ext");

        String world = commandContext.getAttribute(helloKey);
        Assertions.assertEquals("world", world, String.format("Get the attribute:[%s] error", helloKey));

        log.info("test testSetAttribute() succeed...");
    }

    @Test
    @Order(2)
    public void testGetAttribute() {
        final String helloKey = "hello";
        final String testKey = "test";

        TestCommandContext commandContext = TestCommandContextFactory.createTestCommandContext();
        commandContext.setAttribute(helloKey, "world");
        commandContext.setAttribute(testKey, "Flowable-ext");

        String world = commandContext.getAttribute(helloKey);
        Assertions.assertEquals("world", world, String.format("Get the attribute:[%s] error", helloKey));

        log.info("test testGetAttribute() succeed...");
    }

    @Test
    @Order(3)
    public void testGetAttributes() {
        final String helloKey = "hello";
        final String testKey = "test";

        TestCommandContext commandContext = TestCommandContextFactory.createTestCommandContext();
        commandContext.setAttribute(helloKey, "world");
        commandContext.setAttribute(testKey, "Flowable-ext");

        Map<String, Object> attributes = commandContext.getAttributes();
        Assertions.assertTrue(2 == attributes.size(), String.format("Get the attributes error"));
        Assertions.assertEquals("world", attributes.get(helloKey), String.format("Get the attribute:[%s] error", helloKey));
        Assertions.assertEquals("Flowable-ext", attributes.get(testKey), String.format("Get the attribute:[%s] error", testKey));

        log.info("test testGetAttributes() succeed...");
    }

    @Test
    @Order(4)
    public void testGetAttributeWithSupplier() {
        final String notExistKey = "notExistKey";
        final String notExistValue = "notExistValue";

        TestCommandContext commandContext = TestCommandContextFactory.createTestCommandContext();
        String notExistWithSupplier = commandContext.getAttribute(notExistKey, () -> notExistValue);

        Assertions.assertEquals(notExistValue, notExistWithSupplier, String.format("Get the attribute with Supplier error"));
        log.info("test testGetAttributeWithSupplier() succeed...");
    }
}
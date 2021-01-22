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

package com.photowey.flowable.ext.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * IEntityTest
 *
 * @author photowey
 * @date 2021/01/23
 * @since 1.0.0
 */
public class IEntityTest {

    @Test
    public void testEntity() {
        IEntity entity = new TestUser();
        entity.setId(9527L);
        Date now = new Date();
        entity.setCreateTime(now);
        entity.setModifiedTime(now);

        Assertions.assertEquals(9527L, entity.getId(), "handle entity's properties error.");
    }
}
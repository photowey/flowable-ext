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

package com.photowey.flowable.ext.common.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@code Synchronizer} for test.
 *
 * @author photowey
 * @date 2021/01/09
 * @since 1.0.0
 */
public class Synchronizer {

    private static final Logger log = LoggerFactory.getLogger(Synchronizer.class);

    private final ReentrantLock LOCK = new ReentrantLock();
    private final Condition STOP = LOCK.newCondition();

    public Synchronizer() {
    }

    public void sync() {
        this.sync(-1, null);
    }

    public void sync(long time) {
        this.sync(time, TimeUnit.MILLISECONDS);
    }

    public void sync(long time, TimeUnit timeUnit) {
        LOCK.lock();
        try {
            log.info("app is sync running ... ");
            if (time > 0) {
                STOP.await(time, timeUnit);
            } else {
                STOP.await();
            }
        } catch (InterruptedException e) {
            log.error("app interrupted error ", e);
        } finally {
            LOCK.unlock();
        }
    }
}

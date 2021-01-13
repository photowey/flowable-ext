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

package com.photowey.flowable.ext.modeler.id;

/**
 * Snowflake
 * Twitter Snowflake
 *
 * @author photowey
 * @date 2021/01/14
 * @since 1.0.0
 */
public class Snowflake {

    // ==============================Fields===========================================

    // 2019-10-24 16:37:58 -> 0~9

    private final long twepoch = 1571906278000L;

    private final long workerIdBits = 5L;

    private final long dataCenterIdBits = 5L;

    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    private final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);

    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;

    private final long dataCenterIdShift = sequenceBits + workerIdBits;

    private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;

    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;

    private long dataCenterId;

    private long sequence = 0L;

    private long lastTimestamp = -1L;

    //==============================Constructors=====================================

    public Snowflake(Long workerId, Long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("dataCenter Id can't be greater than %d or less than 0", maxDataCenterId));
        }

        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    // ==============================Methods==========================================

    public synchronized Long nextId() {
        // 获取当前时间戳
        long timestamp = this.timeGen();

        //如果当前时间小于上一次ID生成的时间戳,说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", (lastTimestamp - timestamp)));
        }

        //如果是同一时间生成的,则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = this.tilNextMillis(lastTimestamp);
            }
        } else {
            //时间戳改变,毫秒内序列重置
            sequence = 0L;
        }

        //上次生成ID的时间截
        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    protected Long tilNextMillis(Long lastTimestamp) {
        // 获取当前时间戳
        Long timestamp = this.timeGen();
        // 直到-获取下一个时间戳
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }

        return timestamp;
    }

    protected long timeGen() {
        //获取当前时间
        return System.currentTimeMillis();
    }
}

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

package com.photowey.flowable.ext.mybatis.model;

import java.io.Serializable;

/**
 * NativeQueryAdaptor
 *
 * @author photowey
 * @date 2020/12/30
 * @since 1.0.0
 */
public class NativeQueryAdaptor implements Serializable {

    private static final long serialVersionUID = -4121896640452270407L;

    private String customSQL;

    private Integer offset;
    private Integer limit;

    public String getCustomSQL() {
        return customSQL;
    }

    public void setCustomSQL(String customSQL) {
        this.customSQL = customSQL;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public static NativeQueryAdaptor.NativeQueryAdaptorBuilder builder() {
        return new NativeQueryAdaptor.NativeQueryAdaptorBuilder();
    }

    public NativeQueryAdaptor() {
    }

    public NativeQueryAdaptor(final String customSQL, final Integer offset, final Integer limit) {
        this.customSQL = customSQL;
        this.offset = offset;
        this.limit = limit;
    }

    public static class NativeQueryAdaptorBuilder {
        private String customSQL;
        private Integer offset;
        private Integer limit;
        private Integer pageNo;
        private Integer pageSize;

        NativeQueryAdaptorBuilder() {
        }

        public NativeQueryAdaptor.NativeQueryAdaptorBuilder customSQL(final String customSQL) {
            this.customSQL = customSQL;
            return this;
        }

        public NativeQueryAdaptor.NativeQueryAdaptorBuilder offset(final Integer offset) {
            this.offset = offset;
            return this;
        }

        public NativeQueryAdaptor.NativeQueryAdaptorBuilder limit(final Integer limit) {
            this.limit = limit;
            return this;
        }

        public NativeQueryAdaptor build() {
            return new NativeQueryAdaptor(this.customSQL, this.offset, this.limit);
        }

        public String toString() {
            return "NativeQueryAdaptor.NativeQueryAdaptorBuilder(customSQL=" + this.customSQL + ", offset=" + this.offset + ", limit=" + this.limit + ")";
        }
    }
}

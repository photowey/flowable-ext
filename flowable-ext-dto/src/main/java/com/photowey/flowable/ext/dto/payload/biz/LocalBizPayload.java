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

package com.photowey.flowable.ext.dto.payload.biz;

import com.photowey.flowable.ext.dto.payload.AbstractPayload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * {@code LocalBizPayload}
 *
 * @author photowey
 * @date 2021/01/29
 * @since 1.0.0
 */
public class LocalBizPayload implements Serializable {

    private static final long serialVersionUID = 6288113454337887962L;

    /**
     * Create payload.
     */
    public static class LocalBizCreatePayload implements Serializable {

        private static final long serialVersionUID = -8625622130184452247L;

        /**
         * The biz name.
         */
        @NotBlank
        protected String bizName;
        /**
         * The biz category.
         */
        @NotBlank
        protected String category;
        /**
         * The biz tenant.
         */
        @NotBlank
        protected String tenant;
        /**
         * The pre-biz(category).
         */
        protected String preBiz;
        /**
         * The post-biz(category).
         */
        protected String postBiz;

        public String getBizName() {
            return bizName;
        }

        public void setBizName(String bizName) {
            this.bizName = bizName;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTenant() {
            return tenant;
        }

        public void setTenant(String tenant) {
            this.tenant = tenant;
        }

        public String getPreBiz() {
            return preBiz;
        }

        public void setPreBiz(String preBiz) {
            this.preBiz = preBiz;
        }

        public String getPostBiz() {
            return postBiz;
        }

        public void setPostBiz(String postBiz) {
            this.postBiz = postBiz;
        }
    }

    /**
     * Update payload.
     */
    public static class LocalBizUpdatePayload extends LocalBizCreatePayload implements Serializable {

        private static final long serialVersionUID = -6556860511966443706L;

        /**
         * The primary key.
         */
        @NotNull
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    /**
     * Delete payload.
     */
    public static class LocalBizDeletePayload extends AbstractPayload implements Serializable {

        private static final long serialVersionUID = -6556860511966443706L;

        /**
         * Batch delete.
         */
        private List<Long> ids;

        public List<Long> getIds() {
            return ids;
        }

        public void setIds(List<Long> ids) {
            this.ids = ids;
        }
    }
}

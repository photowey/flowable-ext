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

package com.photowey.flowable.ext.dto.query.biz;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * {@code LocalBizQuery}
 *
 * @author photowey
 * @date 2021/01/29
 * @since 1.0.0
 */
public class LocalBizQuery implements Serializable {

    private static final long serialVersionUID = -6269098979354182729L;

    /**
     * The primary key.
     * ==
     */
    private Long id;
    /**
     * The biz name.
     * %xxx%
     */
    private String bizName;
    /**
     * The biz category.
     * %xxx%
     */
    private String category;
    /**
     * The biz tenant.
     * ==
     */
    private String tenant;
    /**
     * The pre-biz(category).
     * ==
     */
    private String preBiz;
    /**
     * The post-biz(category).
     * ==
     */
    private String postBiz;
    /**
     * The create-time as timestamp(start).
     */
    @Min(value = 0)
    private Long createTimeStart;
    /**
     * The create-time as timestamp(end).
     */
    @Min(value = 0)
    private Long createTimeEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Long createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Long getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Long createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}

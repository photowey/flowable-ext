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

package com.photowey.flowable.ext.entity.biz;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.photowey.flowable.ext.entity.IEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * {@code LocalBiz}
 *
 * @author photowey
 * @date 2021/01/28
 * @since 1.0.0
 */
public class LocalBiz implements Serializable, IEntity {

    private static final long serialVersionUID = 5712952447846125813L;

    /**
     * The primary key.
     */
    @TableId
    private Long id;
    /**
     * The biz name.
     */
    private String bizName;
    /**
     * The biz category.
     */
    private String category;
    /**
     * The biz tenant.
     */
    private String tenant;
    /**
     * The pre-biz(category).
     */
    private String preBiz;
    /**
     * The post-biz(category).
     */
    private String postBiz;
    /**
     * The create time.
     */
    @TableField(value = "gmt_create")
    private Date createTime;
    /**
     * The modified time.
     */
    @TableField(value = "gmt_modified")
    private Date modifiedTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getModifiedTime() {
        return modifiedTime;
    }

    @Override
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}

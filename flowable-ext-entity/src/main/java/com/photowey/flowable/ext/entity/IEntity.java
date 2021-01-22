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

import java.util.Date;

/**
 * {@code IEntity}
 * The base Entity
 *
 * @author photowey
 * @date 2021/01/23
 * @since 1.0.0
 */
public interface IEntity {

    // id, gmt_create, gmt_modified
    // id unsigned bigint
    // gmt_create, gmt_modified -> date_time

    /**
     * Set primary-key
     * {@code id}
     *
     * @param id The primary-key.
     */
    void setId(Long id);

    /**
     * Get primary-key
     * {@code id}
     *
     * @return
     */
    Long getId();

    /**
     * Set create time.
     * {@code gmt_create}
     * dddd
     *
     * @param createTime {@link Date}
     */
    void setCreateTime(Date createTime);

    /**
     * Get create time.
     * {@code gmt_create}
     */
    Date getCreateTime();

    /**
     * Set modified time.
     * {@code gmt_modified}
     *
     * @param modifiedTime {@link Date}
     */
    void setModifiedTime(Date modifiedTime);

    /**
     * Get modified time.
     * {@code gmt_modified}
     */
    Date getModifiedTime();
}

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

package com.photowey.flowable.ext.dto.payload;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * {@code Payload}
 *
 * @author photowey
 * @date 2021/01/29
 * @since 1.0.0
 */
public abstract class AbstractPayload implements Serializable {

    private static final long serialVersionUID = -2363594440088400897L;

    /**
     * The primary key.
     */
    @NotNull
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

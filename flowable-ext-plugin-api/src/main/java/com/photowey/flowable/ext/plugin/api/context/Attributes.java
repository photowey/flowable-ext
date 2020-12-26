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

package com.photowey.flowable.ext.plugin.api.context;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Attributes
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface Attributes {

    /**
     * Set Attribute.
     *
     * @param key   The key
     * @param value The value
     * @param <T>   The Type
     */
    <T> void setAttribute(String key, T value);

    /**
     * Get Attribute.
     * if the key not exist, will be return null.
     *
     * @param key The key
     * @param <T> The type
     * @return T type
     */
    <T> T getAttribute(String key);

    /**
     * Get Attributes.
     *
     * @return {@link Map<String, Object>}
     */
    Map<String, Object> getAttributes();

    /**
     * Get Attribute and apply a Supplier<T> function used when the Key not exist
     *
     * @param key      The key
     * @param supplier {@link Supplier}
     * @param <T>      The type
     * @return T type
     */
    <T> T getAttribute(String key, Supplier<T> supplier);
}

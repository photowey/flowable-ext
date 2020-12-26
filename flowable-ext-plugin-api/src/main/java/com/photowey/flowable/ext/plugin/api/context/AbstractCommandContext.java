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

import com.photowey.flowable.ext.plugin.api.feature.Feature;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * CommandContext
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public abstract class AbstractCommandContext implements Attributes {

    /**
     * The attributes container
     */
    private Map<String, Object> attributes = new ConcurrentHashMap<>();

    /**
     * Set Attribute.
     *
     * @param key   The key
     * @param value The value
     * @param <T>   The Type
     */
    @Override
    public <T> void setAttribute(String key, T value) {
        this.attributes.put(key, value);
    }

    /**
     * Get Attribute.
     * if the key not exist, will be return null.
     *
     * @param key The key
     * @param <T> The type
     * @return T type
     */
    @Override
    public <T> T getAttribute(String key) {
        return (T) this.attributes.get(key);
    }

    /**
     * Get Attributes.
     *
     * @return {@link Map<String, Object>}
     */
    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    /**
     * Get Attribute and apply a Supplier<T> function used when the Key not exist
     *
     * @param key      The key
     * @param supplier {@link Supplier}
     * @param <T>      The type
     * @return T type
     */
    @Override
    public <T> T getAttribute(String key, Supplier<T> supplier) {
        if (attributes.containsKey(key)) {
            return (T) attributes.get(key);
        }
        T expect = supplier.get();
        this.attributes.put(key, expect);

        return expect;
    }

    /**
     * The command Feature
     */
    public Feature feature;

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}

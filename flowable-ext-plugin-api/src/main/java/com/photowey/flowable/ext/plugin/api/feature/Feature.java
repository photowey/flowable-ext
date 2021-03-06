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

package com.photowey.flowable.ext.plugin.api.feature;

import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;
import com.photowey.flowable.ext.plugin.api.inspector.Inspector;
import com.photowey.flowable.ext.plugin.api.rule.Rule;
import com.photowey.flowable.ext.plugin.api.storage.Storage;

/**
 * {@code Feature} is an interface that can be implemented by objects.
 * A {@code Feature} include {@link Inspector}, {@link Rule} and {@link Storage}
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface Feature<T extends AbstractCommandContext> {

    /**
     * Get the {@link Inspector}.
     */
    default Inspector<T> getInspector() {
        return null;
    }

    /**
     * Get the {@link Rule}.
     */
    default Rule<T> getRule() {
        return null;
    }

    /**
     * Get the {@link Storage}.
     */
    default Storage<T> getStorage() {
        return null;
    }
}

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

package com.photowey.flowable.ext.plugin.api.order;

/**
 * Extension of the {@link Ordered} interface.
 * {@code PriorityOrdered} objects are always applied before
 * plain {@link Ordered} objects regardless of their order values.
 * <p>
 * The design idea comes from Springframework
 * {@code org.springframework.core.PriorityOrdered}
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface PriorityOrdered extends Ordered {
}

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

package com.photowey.flowable.ext.mybatis.api.service;

import com.photowey.flowable.ext.mybatis.api.model.NativeQueryAdaptor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * NativeQueryService
 *
 * @author photowey
 * @date 2020/12/30
 * @since 1.0.0
 */
public interface NativeQueryService {

    long count(NativeQueryAdaptor query);

    <T> T singleResult(NativeQueryAdaptor query, Function<Map<String, Object>, T> converter);

    <T> List<T> list(NativeQueryAdaptor query, Function<Map<String, Object>, T> converter);

    <T> List<T> listPage(NativeQueryAdaptor query, Function<Map<String, Object>, T> converter);
}

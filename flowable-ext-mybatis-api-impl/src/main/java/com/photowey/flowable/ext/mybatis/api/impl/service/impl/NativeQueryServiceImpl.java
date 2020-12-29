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

package com.photowey.flowable.ext.mybatis.api.impl.service.impl;

import com.photowey.flowable.ext.mybatis.api.mapper.NativeQueryMapper;
import com.photowey.flowable.ext.mybatis.api.model.NativeQueryAdaptor;
import com.photowey.flowable.ext.mybatis.api.service.NativeQueryService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * NativeQueryServiceImpl
 *
 * @author photowey
 * @date 2020/12/30
 * @since 1.0.0
 */
public class NativeQueryServiceImpl implements NativeQueryService {

    private final NativeQueryMapper nativeQueryMapper;

    public NativeQueryServiceImpl(NativeQueryMapper nativeQueryMapper) {
        this.nativeQueryMapper = nativeQueryMapper;
    }

    @Override
    public long count(NativeQueryAdaptor query) {
        return this.nativeQueryMapper.count(query);
    }

    @Override
    public <T> T singleResult(NativeQueryAdaptor query, Function<Map<String, Object>, T> converter) {
        Map<String, Object> result = this.nativeQueryMapper.singleResult(query);
        return this.transfer(result, converter);
    }

    @Override
    public <T> List<T> list(NativeQueryAdaptor query, Function<Map<String, Object>, T> converter) {
        List<Map<String, Object>> results = this.nativeQueryMapper.list(query);
        return results.stream().map(result -> this.transfer(result, converter)).collect(Collectors.toList());
    }

    @Override
    public <T> List<T> listPage(NativeQueryAdaptor query, Function<Map<String, Object>, T> converter) {
        List<Map<String, Object>> results = this.nativeQueryMapper.listPage(query);
        return results.stream().map(result -> this.transfer(result, converter)).collect(Collectors.toList());
    }

    public <T> T transfer(Map<String, Object> original, Function<Map<String, Object>, T> converter) {
        return converter.apply(original);

    }
}

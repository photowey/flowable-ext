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

package com.photowey.flowable.ext.mybatis.api.query;

import com.photowey.flowable.ext.mybatis.model.NativeQueryAdaptor;
import com.photowey.flowable.ext.mybatis.api.service.NativeQueryService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * AbstractNativeQueryExt
 *
 * @author photowey
 * @date 2021/01/01
 * @since 1.0.0
 */
public abstract class AbstractNativeQueryExt<Q extends NativeQueryExt<Q>> implements NativeQueryExt<Q> {

    protected String customSQL;

    protected Integer offset;
    protected Integer limit;

    protected final NativeQueryService nativeQueryService;

    public AbstractNativeQueryExt(NativeQueryService nativeQueryService) {
        this.nativeQueryService = nativeQueryService;
    }

    public Q customSQL(String customSQL) {
        this.customSQL = customSQL;
        return (Q) this;
    }

    @Override
    public long count() {
        NativeQueryAdaptor query = NativeQueryAdaptor
                .builder()
                .customSQL(this.customSQL)
                .build();
        return this.nativeQueryService.count(query);
    }

    @Override
    public Map<String, Object> singleResult() {
        NativeQueryAdaptor query = NativeQueryAdaptor
                .builder()
                .customSQL(this.customSQL)
                .build();
        return this.nativeQueryService.singleResult(query);
    }

    @Override
    public List<Map<String, Object>> list() {
        NativeQueryAdaptor query = NativeQueryAdaptor
                .builder()
                .customSQL(this.customSQL)
                .build();
        return this.nativeQueryService.list(query);
    }

    @Override
    public List<Map<String, Object>> listPage(int offset, int limit) {
        NativeQueryAdaptor query = NativeQueryAdaptor
                .builder()
                .customSQL(this.customSQL)
                .offset(offset)
                .limit(limit)
                .build();
        return this.nativeQueryService.listPage(query);
    }

    @Override
    public <U> U singleResult(Function<Map<String, Object>, U> converter) {
        this.offset = 0;
        this.limit = 1;
        List<U> rows = this.list(converter);
        if (rows.size() > 0) {
            return rows.get(0);
        }
        return null;
    }

    @Override
    public <U> List<U> list(Function<Map<String, Object>, U> converter) {
        this.offset = 0;
        this.limit = 0;
        return this.listPage(converter);
    }

    @Override
    public <U> List<U> listPage(Function<Map<String, Object>, U> converter) {
        return this.executePage(converter);
    }

    public abstract <T, U> List<U> executePage(Function<Map<String, Object>, U> converter);
}

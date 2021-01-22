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

package com.photowey.flowable.ext.mybatis.api.impl.query.impl;

import com.photowey.flowable.ext.mybatis.api.query.AbstractNativeQueryExt;
import com.photowey.flowable.ext.mybatis.api.service.NativeQueryService;
import com.photowey.flowable.ext.mybatis.model.NativeQueryAdaptor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * NativeQueryExtImpl
 *
 * @author photowey
 * @date 2021/01/01
 * @since 1.0.0
 */
public class NativeQueryExtImpl extends AbstractNativeQueryExt<NativeQueryExtImpl> {

    private int pageNo;
    private int pageSize;

    public NativeQueryExtImpl(NativeQueryService nativeQueryService) {
        super(nativeQueryService);
    }

    @Override
    public NativeQueryExtImpl pageNo(final int pageNo) {
        assert pageNo >= 0;
        this.pageNo = pageNo;
        return this;
    }

    @Override
    public NativeQueryExtImpl pagSize(final int pageSize) {
        assert pageSize >= 0;
        this.pageSize = pageSize;
        this.limit = pageSize;
        this.offset = (this.pageNo - 1) * this.pageSize;
        return this;
    }

    @Override
    public <T, U> List<U> executePage(Function<Map<String, Object>, U> converter) {
        NativeQueryAdaptor.NativeQueryAdaptorBuilder queryBuilder = NativeQueryAdaptor
                .builder()
                .customSQL(this.customSQL);
        if (this.pageSize > 0) {
            NativeQueryAdaptor query = queryBuilder.offset(this.offset).limit(this.limit).build();
            return this.nativeQueryService.listPage(query, converter);
        }
        NativeQueryAdaptor query = queryBuilder.build();
        return this.nativeQueryService.listPage(query, converter);
    }
}

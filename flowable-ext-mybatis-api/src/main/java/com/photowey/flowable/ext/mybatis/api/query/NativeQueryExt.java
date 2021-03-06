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

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * {@code NativeQueryExt} is an interface that extends(ext) {@code org.flowable.common.engine.api.query.NativeQuery}
 * provides access to flowable database by native SQL.
 *
 * @author photowey
 * @date 2020/12/30
 * @since 1.0.0
 */
public interface NativeQueryExt<Q extends NativeQueryExt<Q>> extends Criteria<Map<String, Object>> {

    Q customSQL(final String customSQL);

    Q pageNo(final int pageNo);

    Q pagSize(final int pageSize);

    <U> U singleResult(Function<Map<String, Object>, U> converter);

    <U> List<U> list(Function<Map<String, Object>, U> converter);

    <U> List<U> listPage(Function<Map<String, Object>, U> converter);

}

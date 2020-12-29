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

import com.photowey.flowable.ext.mybatis.api.model.NativeQueryAdaptor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * {@code NativeQueryExt} is an interface that extends(ext) {@code org.flowable.common.engine.api.query.NativeQuery}
 * provides access to flowable database by native SQL.
 *
 * @author photowey
 * @date 2020/12/30
 * @since 1.0.0
 */
public interface NativeQueryExt {

    Long count(@Param("query") NativeQueryAdaptor query);

    Map<String, Object> singleResult(@Param("query") NativeQueryAdaptor query);

    List<Map<String, Object>> list(@Param("query") NativeQueryAdaptor query);

    List<Map<String, Object>> listPage(@Param("query") NativeQueryAdaptor query);
}

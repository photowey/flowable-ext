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

package com.photowey.flowable.ext.auto.configurer.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * {@code FlowableExtProperties} is a Properties that extension the flowable-ext properties.
 *
 * @author photowey
 * @date 2021/01/18
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "flowable.ext", ignoreUnknownFields = true, ignoreInvalidFields = false)
public class FlowableExtProperties {

    private static final String MAPPER_BASE_PACKAGE = "com.photowey.flowable.ext.mybatis.api.mapper";

    private Mapper mapper = new Mapper();

    public static class Mapper {
        private String basePackage = MAPPER_BASE_PACKAGE;

        public String getBasePackage() {
            return basePackage;
        }

        public void setBasePackage(String basePackage) {
            this.basePackage = basePackage;
        }
    }

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
}

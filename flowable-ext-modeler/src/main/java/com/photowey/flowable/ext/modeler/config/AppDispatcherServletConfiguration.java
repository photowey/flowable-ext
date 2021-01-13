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

package com.photowey.flowable.ext.modeler.config;

import org.flowable.ui.modeler.rest.app.EditorGroupsResource;
import org.flowable.ui.modeler.rest.app.EditorUsersResource;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * AppDispatcherServletConfiguration
 *
 * @author photowey
 * @date 2021/01/13
 * @since 1.0.0
 */
@EnableAsync
@Configuration
@ComponentScans({
        @ComponentScan(value = {"org.flowable.ui.modeler.rest.app"}),
        @ComponentScan(excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = EditorUsersResource.class), // temp
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = EditorGroupsResource.class), // temp
        })
})
public class AppDispatcherServletConfiguration implements WebMvcRegistrations {

    @Bean
    public SessionLocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.setPatternParser(new PathPatternParser());
        requestMappingHandlerMapping.setRemoveSemicolonContent(false);
        Object[] interceptors = {localeChangeInterceptor()};
        requestMappingHandlerMapping.setInterceptors(interceptors);

        return requestMappingHandlerMapping;
    }
}
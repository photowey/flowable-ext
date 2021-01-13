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

import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.flowable.ui.modeler.properties.FlowableModelerAppProperties;
import org.flowable.ui.modeler.servlet.ApiDispatcherServletConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * ApplicationConfiguration
 *
 * @author photowey
 * @date 2021/01/13
 * @since 1.0.0
 */
@Configuration
@ComponentScans({
        @ComponentScan(basePackages = {
                "org.flowable.ui.modeler.repository",
                "org.flowable.ui.modeler.service",
                "org.flowable.ui.common.service",
                "org.flowable.ui.common.repository",
                "org.flowable.ui.common.tenant"
        }),
        @ComponentScan(excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RemoteIdmService.class)
        })
})
@EnableConfigurationProperties(FlowableModelerAppProperties.class)
public class ApplicationConfiguration {

    @Bean
    public ServletRegistrationBean apiServlet(ApplicationContext applicationContext) {
        AnnotationConfigWebApplicationContext dispatcherServletConfiguration = new AnnotationConfigWebApplicationContext();
        dispatcherServletConfiguration.setParent(applicationContext);
        dispatcherServletConfiguration.register(ApiDispatcherServletConfiguration.class);
        DispatcherServlet servlet = new DispatcherServlet(dispatcherServletConfiguration);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet, "/api/**");
        registrationBean.setName("flowable-idm-app-api-servlet");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }
}

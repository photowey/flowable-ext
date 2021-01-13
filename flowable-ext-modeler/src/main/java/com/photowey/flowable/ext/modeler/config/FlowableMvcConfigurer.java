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

import com.photowey.flowable.ext.modeler.id.Snowflake;
import org.flowable.common.engine.impl.cfg.IdGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * FlowableMvcConfigurer
 *
 * @author photowey
 * @date 2021/01/14
 * @since 1.0.0
 */
@Configuration
public class FlowableMvcConfigurer implements WebMvcConfigurer, EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");*/
    }

    @Override
    public void configure(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        springProcessEngineConfiguration.setIdGenerator(this.flowableIdGenerator());
    }

    @Bean
    public IdGenerator flowableIdGenerator() {
        return new IdGeneratorImpl(1L, 1L);
    }

    public static class IdGeneratorImpl implements IdGenerator {

        private Snowflake snowflake;

        public IdGeneratorImpl(Long workerId, Long dataCenterId) {
            this.snowflake = new Snowflake(workerId, dataCenterId);
        }

        @Override
        public String getNextId() {
            return String.valueOf(this.snowflake.nextId());
        }
    }
}

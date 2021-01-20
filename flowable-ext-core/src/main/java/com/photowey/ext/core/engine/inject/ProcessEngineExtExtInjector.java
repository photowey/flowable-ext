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

package com.photowey.ext.core.engine.inject;

import com.photowey.ext.core.api.aware.ProcessEngineExtAware;
import com.photowey.ext.core.api.engine.ProcessEngineExt;
import com.photowey.ext.core.api.engine.inject.ProcessEngineExtInjector;
import com.photowey.flowable.ext.common.util.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Collection;
import java.util.Map;

/**
 * {@code ProcessEngineExtBeanPostProcessor} is an injector that
 * provide the entry of inject {@link  ProcessEngineExt} into the candidates.
 *
 * @author photowey
 * @date 2021/01/05
 * @since 1.0.0
 */
public class ProcessEngineExtExtInjector implements ProcessEngineExtInjector, BeanFactoryAware, BeanPostProcessor {

    private final ProcessEngineExt processEngineExt;

    private ConfigurableListableBeanFactory beanFactory;

    public ProcessEngineExtExtInjector(ProcessEngineExt processEngineExt) {
        this.processEngineExt = processEngineExt;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // To -> com.photowey.ext.core.engine.inject.ProcessEngineExtExtInjector.postProcessAfterInitialization()
        // this.handlePostInject(this.processEngineExt);
    }

    @Override
    public void handlePostInject(ProcessEngineExt processEngineExt) {
        Map<String, ProcessEngineExtAware> beanMap = this.beanFactory.getBeansOfType(ProcessEngineExtAware.class);
        Collection<ProcessEngineExtAware> candidates = beanMap.values();
        if (CollectionUtils.isNotEmpty(candidates)) {
            candidates.forEach(candidate -> candidate.setProcessEngineExt(processEngineExt));
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ProcessEngineExtAware) {
            ProcessEngineExtAware candidate = (ProcessEngineExtAware) bean;
            // Injecting {@code ProcessEngineExt}.
            candidate.setProcessEngineExt(this.processEngineExt);
        }

        return bean;
    }
}

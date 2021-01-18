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

package com.photowe.ext.core.form;

import org.flowable.engine.FormService;
import org.flowable.engine.form.StartFormData;
import org.flowable.engine.form.TaskFormData;
import org.flowable.engine.runtime.ProcessInstance;

import java.util.Map;

/**
 * {@code AbstractFormServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/19
 * @since 1.0.0
 */
public abstract class AbstractFormServiceDelegate implements FormService {

    /**
     * Get {@link FormService} instance.
     *
     * @return {@link FormService}
     */
    public abstract FormService getFormService();

    @Override
    public StartFormData getStartFormData(String processDefinitionId) {
        return this.getFormService().getStartFormData(processDefinitionId);
    }

    @Override
    public Object getRenderedStartForm(String processDefinitionId) {
        return this.getFormService().getRenderedStartForm(processDefinitionId);
    }

    @Override
    public Object getRenderedStartForm(String processDefinitionId, String formEngineName) {
        return this.getFormService().getRenderedStartForm(processDefinitionId, formEngineName);
    }

    @Override
    public ProcessInstance submitStartFormData(String processDefinitionId, Map<String, String> properties) {
        return this.getFormService().submitStartFormData(processDefinitionId, properties);
    }

    @Override
    public ProcessInstance submitStartFormData(String processDefinitionId, String businessKey, Map<String, String> properties) {
        return this.getFormService().submitStartFormData(processDefinitionId, businessKey, properties);
    }

    @Override
    public TaskFormData getTaskFormData(String taskId) {
        return this.getFormService().getTaskFormData(taskId);
    }

    @Override
    public Object getRenderedTaskForm(String taskId) {
        return this.getFormService().getRenderedTaskForm(taskId);
    }

    @Override
    public Object getRenderedTaskForm(String taskId, String formEngineName) {
        return this.getFormService().getRenderedTaskForm(taskId, formEngineName);
    }

    @Override
    public void submitTaskFormData(String taskId, Map<String, String> properties) {
        this.getFormService().submitTaskFormData(taskId, properties);
    }

    @Override
    public void saveFormData(String taskId, Map<String, String> properties) {
        this.getFormService().saveFormData(taskId, properties);
    }

    @Override
    public String getStartFormKey(String processDefinitionId) {
        return this.getFormService().getStartFormKey(processDefinitionId);
    }

    @Override
    public String getTaskFormKey(String processDefinitionId, String taskDefinitionKey) {
        return this.getFormService().getTaskFormKey(processDefinitionId, taskDefinitionKey);
    }
}

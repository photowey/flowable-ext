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

package com.photowe.ext.core.history;

import org.flowable.engine.HistoryService;
import org.flowable.engine.history.*;
import org.flowable.entitylink.api.history.HistoricEntityLink;
import org.flowable.identitylink.api.history.HistoricIdentityLink;
import org.flowable.task.api.TaskInfo;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
import org.flowable.task.api.history.HistoricTaskLogEntryBuilder;
import org.flowable.task.api.history.HistoricTaskLogEntryQuery;
import org.flowable.task.api.history.NativeHistoricTaskLogEntryQuery;
import org.flowable.task.service.history.NativeHistoricTaskInstanceQuery;
import org.flowable.variable.api.history.HistoricVariableInstanceQuery;
import org.flowable.variable.api.history.NativeHistoricVariableInstanceQuery;

import java.util.List;

/**
 * {@code AbstractHistoryServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/19
 * @since 1.0.0
 */
public abstract class AbstractHistoryServiceDelegate implements HistoryService {

    /**
     * Get {@link HistoryService} instance.
     *
     * @return {@link HistoryService}
     */
    public abstract HistoryService getHistoryService();

    @Override
    public HistoricProcessInstanceQuery createHistoricProcessInstanceQuery() {
        return this.getHistoryService().createHistoricProcessInstanceQuery();
    }

    @Override
    public HistoricActivityInstanceQuery createHistoricActivityInstanceQuery() {
        return this.getHistoryService().createHistoricActivityInstanceQuery();
    }

    @Override
    public HistoricTaskInstanceQuery createHistoricTaskInstanceQuery() {
        return this.getHistoryService().createHistoricTaskInstanceQuery();
    }

    @Override
    public HistoricDetailQuery createHistoricDetailQuery() {
        return this.getHistoryService().createHistoricDetailQuery();
    }

    @Override
    public NativeHistoricDetailQuery createNativeHistoricDetailQuery() {
        return this.getHistoryService().createNativeHistoricDetailQuery();
    }

    @Override
    public HistoricVariableInstanceQuery createHistoricVariableInstanceQuery() {
        return this.getHistoryService().createHistoricVariableInstanceQuery();
    }

    @Override
    public NativeHistoricVariableInstanceQuery createNativeHistoricVariableInstanceQuery() {
        return this.getHistoryService().createNativeHistoricVariableInstanceQuery();
    }

    @Override
    public void deleteHistoricTaskInstance(String taskId) {
        this.getHistoryService().deleteHistoricTaskInstance(taskId);
    }

    @Override
    public void deleteHistoricProcessInstance(String processInstanceId) {
        this.getHistoryService().deleteHistoricProcessInstance(processInstanceId);
    }

    @Override
    public void deleteTaskAndActivityDataOfRemovedHistoricProcessInstances() {
        this.getHistoryService().deleteTaskAndActivityDataOfRemovedHistoricProcessInstances();
    }

    @Override
    public void deleteRelatedDataOfRemovedHistoricProcessInstances() {
        this.getHistoryService().deleteRelatedDataOfRemovedHistoricProcessInstances();
    }

    @Override
    public NativeHistoricProcessInstanceQuery createNativeHistoricProcessInstanceQuery() {
        return this.getHistoryService().createNativeHistoricProcessInstanceQuery();
    }

    @Override
    public NativeHistoricTaskInstanceQuery createNativeHistoricTaskInstanceQuery() {
        return this.getHistoryService().createNativeHistoricTaskInstanceQuery();
    }

    @Override
    public NativeHistoricActivityInstanceQuery createNativeHistoricActivityInstanceQuery() {
        return this.getHistoryService().createNativeHistoricActivityInstanceQuery();
    }

    @Override
    public List<HistoricIdentityLink> getHistoricIdentityLinksForTask(String taskId) {
        return this.getHistoryService().getHistoricIdentityLinksForTask(taskId);
    }

    @Override
    public List<HistoricIdentityLink> getHistoricIdentityLinksForProcessInstance(String processInstanceId) {
        return this.getHistoryService().getHistoricIdentityLinksForProcessInstance(processInstanceId);
    }

    @Override
    public List<HistoricEntityLink> getHistoricEntityLinkChildrenForProcessInstance(String processInstanceId) {
        return this.getHistoryService().getHistoricEntityLinkChildrenForProcessInstance(processInstanceId);
    }

    @Override
    public List<HistoricEntityLink> getHistoricEntityLinkChildrenWithSameRootAsProcessInstance(String processInstanceId) {
        return this.getHistoryService().getHistoricEntityLinkChildrenWithSameRootAsProcessInstance(processInstanceId);
    }

    @Override
    public List<HistoricEntityLink> getHistoricEntityLinkChildrenForTask(String taskId) {
        return this.getHistoryService().getHistoricEntityLinkChildrenForTask(taskId);
    }

    @Override
    public List<HistoricEntityLink> getHistoricEntityLinkParentsForProcessInstance(String processInstanceId) {
        return this.getHistoryService().getHistoricEntityLinkParentsForProcessInstance(processInstanceId);
    }

    @Override
    public List<HistoricEntityLink> getHistoricEntityLinkParentsForTask(String taskId) {
        return this.getHistoryService().getHistoricEntityLinkParentsForTask(taskId);
    }

    @Override
    public ProcessInstanceHistoryLogQuery createProcessInstanceHistoryLogQuery(String processInstanceId) {
        return this.getHistoryService().createProcessInstanceHistoryLogQuery(processInstanceId);
    }

    @Override
    public void deleteHistoricTaskLogEntry(long logNumber) {
        this.getHistoryService().deleteHistoricTaskLogEntry(logNumber);
    }

    @Override
    public HistoricTaskLogEntryBuilder createHistoricTaskLogEntryBuilder(TaskInfo task) {
        return this.getHistoryService().createHistoricTaskLogEntryBuilder(task);
    }

    @Override
    public HistoricTaskLogEntryBuilder createHistoricTaskLogEntryBuilder() {
        return this.getHistoryService().createHistoricTaskLogEntryBuilder();
    }

    @Override
    public HistoricTaskLogEntryQuery createHistoricTaskLogEntryQuery() {
        return this.getHistoryService().createHistoricTaskLogEntryQuery();
    }

    @Override
    public NativeHistoricTaskLogEntryQuery createNativeHistoricTaskLogEntryQuery() {
        return this.getHistoryService().createNativeHistoricTaskLogEntryQuery();
    }
}

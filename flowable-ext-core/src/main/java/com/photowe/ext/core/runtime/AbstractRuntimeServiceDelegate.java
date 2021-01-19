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

package com.photowe.ext.core.runtime;

import org.flowable.bpmn.model.FlowNode;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.*;
import org.flowable.engine.task.Event;
import org.flowable.entitylink.api.EntityLink;
import org.flowable.eventregistry.api.EventRegistryEventConsumer;
import org.flowable.eventsubscription.api.EventSubscriptionQuery;
import org.flowable.form.api.FormInfo;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.variable.api.persistence.entity.VariableInstance;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * {@code AbstractRuntimeServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/19
 * @since 1.0.0
 */
public abstract class AbstractRuntimeServiceDelegate implements RuntimeService {

    public abstract RuntimeService getRuntimeService();

    @Override
    public ProcessInstanceBuilder createProcessInstanceBuilder() {
        return this.getRuntimeService().createProcessInstanceBuilder();
    }

    @Override
    public ProcessInstance startProcessInstanceByKey(String processDefinitionKey) {
        return this.getRuntimeService().startProcessInstanceByKey(processDefinitionKey);
    }

    @Override
    public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String businessKey) {
        return this.getRuntimeService().startProcessInstanceByKey(processDefinitionKey, businessKey);
    }

    @Override
    public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) {
        return this.getRuntimeService().startProcessInstanceByKey(processDefinitionKey, variables);
    }

    @Override
    public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String businessKey, Map<String, Object> variables) {
        return this.getRuntimeService().startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
    }

    @Override
    public ProcessInstance startProcessInstanceByKeyAndTenantId(String processDefinitionKey, String tenantId) {
        return this.getRuntimeService().startProcessInstanceByKeyAndTenantId(processDefinitionKey, tenantId);
    }

    @Override
    public ProcessInstance startProcessInstanceByKeyAndTenantId(String processDefinitionKey, String businessKey, String tenantId) {
        return this.getRuntimeService().startProcessInstanceByKeyAndTenantId(processDefinitionKey, businessKey, tenantId);
    }

    @Override
    public ProcessInstance startProcessInstanceByKeyAndTenantId(String processDefinitionKey, Map<String, Object> variables, String tenantId) {
        return this.getRuntimeService().startProcessInstanceByKeyAndTenantId(processDefinitionKey, variables, tenantId);
    }

    @Override
    public ProcessInstance startProcessInstanceByKeyAndTenantId(String processDefinitionKey, String businessKey, Map<String, Object> variables, String tenantId) {
        return this.getRuntimeService().startProcessInstanceByKeyAndTenantId(processDefinitionKey, businessKey, variables, tenantId);
    }

    @Override
    public ProcessInstance startProcessInstanceById(String processDefinitionId) {
        return this.getRuntimeService().startProcessInstanceById(processDefinitionId);
    }

    @Override
    public ProcessInstance startProcessInstanceById(String processDefinitionId, String businessKey) {
        return this.getRuntimeService().startProcessInstanceById(processDefinitionId, businessKey);
    }

    @Override
    public ProcessInstance startProcessInstanceById(String processDefinitionId, Map<String, Object> variables) {
        return this.getRuntimeService().startProcessInstanceById(processDefinitionId, variables);
    }

    @Override
    public ProcessInstance startProcessInstanceById(String processDefinitionId, String businessKey, Map<String, Object> variables) {
        return this.getRuntimeService().startProcessInstanceById(processDefinitionId, businessKey, variables);
    }

    @Override
    public ProcessInstance startProcessInstanceWithForm(String processDefinitionId, String outcome, Map<String, Object> variables, String processInstanceName) {
        return this.getRuntimeService().startProcessInstanceWithForm(processDefinitionId, outcome, variables, processInstanceName);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessage(String messageName) {
        return this.getRuntimeService().startProcessInstanceByMessage(messageName);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessageAndTenantId(String messageName, String tenantId) {
        return this.getRuntimeService().startProcessInstanceByMessageAndTenantId(messageName, tenantId);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessage(String messageName, String businessKey) {
        return this.getRuntimeService().startProcessInstanceByMessage(messageName, businessKey);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessageAndTenantId(String messageName, String businessKey, String tenantId) {
        return this.getRuntimeService().startProcessInstanceByMessageAndTenantId(messageName, businessKey, tenantId);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessage(String messageName, Map<String, Object> processVariables) {
        return this.getRuntimeService().startProcessInstanceByMessage(messageName, processVariables);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessageAndTenantId(String messageName, Map<String, Object> processVariables, String tenantId) {
        return this.getRuntimeService().startProcessInstanceByMessageAndTenantId(messageName, processVariables, tenantId);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessage(String messageName, String businessKey, Map<String, Object> processVariables) {
        return this.getRuntimeService().startProcessInstanceByMessage(messageName, businessKey, processVariables);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessageAndTenantId(String messageName, String businessKey, Map<String, Object> processVariables, String tenantId) {
        return this.getRuntimeService().startProcessInstanceByMessageAndTenantId(messageName, businessKey, processVariables, tenantId);
    }

    @Override
    public FormInfo getStartFormModel(String processDefinitionId, String processInstanceId) {
        return this.getRuntimeService().getStartFormModel(processDefinitionId, processInstanceId);
    }

    @Override
    public void deleteProcessInstance(String processInstanceId, String deleteReason) {
        this.getRuntimeService().deleteProcessInstance(processInstanceId, deleteReason);
    }

    @Override
    public List<String> getActiveActivityIds(String executionId) {
        return this.getRuntimeService().getActiveActivityIds(executionId);
    }

    @Override
    public void trigger(String executionId) {
        this.getRuntimeService().trigger(executionId);
    }

    @Override
    public void triggerAsync(String executionId) {
        this.getRuntimeService().triggerAsync(executionId);
    }

    @Override
    public void trigger(String executionId, Map<String, Object> processVariables) {
        this.getRuntimeService().trigger(executionId, processVariables);
    }

    @Override
    public void triggerAsync(String executionId, Map<String, Object> processVariables) {
        this.getRuntimeService().triggerAsync(executionId, processVariables);
    }

    @Override
    public void trigger(String executionId, Map<String, Object> processVariables, Map<String, Object> transientVariables) {
        this.getRuntimeService().trigger(executionId, processVariables, transientVariables);
    }

    @Override
    public void evaluateConditionalEvents(String processInstanceId) {
        this.getRuntimeService().evaluateConditionalEvents(processInstanceId);
    }

    @Override
    public void evaluateConditionalEvents(String processInstanceId, Map<String, Object> processVariables) {
        this.getRuntimeService().evaluateConditionalEvents(processInstanceId, processVariables);
    }

    @Override
    public void updateBusinessKey(String processInstanceId, String businessKey) {
        this.getRuntimeService().updateBusinessKey(processInstanceId, businessKey);
    }

    @Override
    public void addUserIdentityLink(String processInstanceId, String userId, String identityLinkType) {
        this.getRuntimeService().addUserIdentityLink(processInstanceId, userId, identityLinkType);
    }

    @Override
    public void addGroupIdentityLink(String processInstanceId, String groupId, String identityLinkType) {
        this.getRuntimeService().addGroupIdentityLink(processInstanceId, groupId, identityLinkType);
    }

    @Override
    public void addParticipantUser(String processInstanceId, String userId) {
        this.getRuntimeService().addParticipantUser(processInstanceId, userId);
    }

    @Override
    public void addParticipantGroup(String processInstanceId, String groupId) {
        this.getRuntimeService().addParticipantGroup(processInstanceId, groupId);
    }

    @Override
    public void deleteParticipantUser(String processInstanceId, String userId) {
        this.getRuntimeService().deleteParticipantUser(processInstanceId, userId);
    }

    @Override
    public void deleteParticipantGroup(String processInstanceId, String groupId) {
        this.getRuntimeService().deleteParticipantGroup(processInstanceId, groupId);
    }

    @Override
    public void deleteUserIdentityLink(String processInstanceId, String userId, String identityLinkType) {
        this.getRuntimeService().deleteUserIdentityLink(processInstanceId, userId, identityLinkType);
    }

    @Override
    public void deleteGroupIdentityLink(String processInstanceId, String groupId, String identityLinkType) {
        this.getRuntimeService().deleteGroupIdentityLink(processInstanceId, groupId, identityLinkType);
    }

    @Override
    public List<IdentityLink> getIdentityLinksForProcessInstance(String instanceId) {
        return this.getRuntimeService().getIdentityLinksForProcessInstance(instanceId);
    }

    @Override
    public List<EntityLink> getEntityLinkChildrenForProcessInstance(String instanceId) {
        return this.getRuntimeService().getEntityLinkChildrenForProcessInstance(instanceId);
    }

    @Override
    public List<EntityLink> getEntityLinkChildrenWithSameRootAsProcessInstance(String instanceId) {
        return this.getRuntimeService().getEntityLinkChildrenWithSameRootAsProcessInstance(instanceId);
    }

    @Override
    public List<EntityLink> getEntityLinkChildrenForTask(String taskId) {
        return this.getRuntimeService().getEntityLinkChildrenForTask(taskId);
    }

    @Override
    public List<EntityLink> getEntityLinkParentsForProcessInstance(String instanceId) {
        return this.getRuntimeService().getEntityLinkParentsForProcessInstance(instanceId);
    }

    @Override
    public List<EntityLink> getEntityLinkParentsForTask(String taskId) {
        return this.getRuntimeService().getEntityLinkParentsForTask(taskId);
    }

    @Override
    public Map<String, Object> getVariables(String executionId) {
        return this.getRuntimeService().getVariables(executionId);
    }

    @Override
    public Map<String, VariableInstance> getVariableInstances(String executionId) {
        return this.getRuntimeService().getVariableInstances(executionId);
    }

    @Override
    public List<VariableInstance> getVariableInstancesByExecutionIds(Set<String> executionIds) {
        return this.getRuntimeService().getVariableInstancesByExecutionIds(executionIds);
    }

    @Override
    public Map<String, Object> getVariablesLocal(String executionId) {
        return this.getRuntimeService().getVariablesLocal(executionId);
    }

    @Override
    public Map<String, VariableInstance> getVariableInstancesLocal(String executionId) {
        return this.getRuntimeService().getVariableInstancesLocal(executionId);
    }

    @Override
    public Map<String, Object> getVariables(String executionId, Collection<String> variableNames) {
        return this.getRuntimeService().getVariables(executionId, variableNames);
    }

    @Override
    public Map<String, VariableInstance> getVariableInstances(String executionId, Collection<String> variableNames) {
        return this.getRuntimeService().getVariableInstances(executionId, variableNames);
    }

    @Override
    public Map<String, Object> getVariablesLocal(String executionId, Collection<String> variableNames) {
        return this.getRuntimeService().getVariablesLocal(executionId, variableNames);
    }

    @Override
    public Map<String, VariableInstance> getVariableInstancesLocal(String executionId, Collection<String> variableNames) {
        return this.getRuntimeService().getVariableInstancesLocal(executionId, variableNames);
    }

    @Override
    public Object getVariable(String executionId, String variableName) {
        return this.getRuntimeService().getVariable(executionId, variableName);
    }

    @Override
    public VariableInstance getVariableInstance(String executionId, String variableName) {
        return this.getRuntimeService().getVariableInstance(executionId, variableName);
    }

    @Override
    public <T> T getVariable(String executionId, String variableName, Class<T> variableClass) {
        return this.getRuntimeService().getVariable(executionId, variableName, variableClass);
    }

    @Override
    public boolean hasVariable(String executionId, String variableName) {
        return this.getRuntimeService().hasVariable(executionId, variableName);
    }

    @Override
    public Object getVariableLocal(String executionId, String variableName) {
        return this.getRuntimeService().getVariableLocal(executionId, variableName);
    }

    @Override
    public VariableInstance getVariableInstanceLocal(String executionId, String variableName) {
        return this.getRuntimeService().getVariableInstanceLocal(executionId, variableName);
    }

    @Override
    public <T> T getVariableLocal(String executionId, String variableName, Class<T> variableClass) {
        return this.getRuntimeService().getVariableLocal(executionId, variableName, variableClass);
    }

    @Override
    public boolean hasVariableLocal(String executionId, String variableName) {
        return this.getRuntimeService().hasVariableLocal(executionId, variableName);
    }

    @Override
    public void setVariable(String executionId, String variableName, Object value) {
        this.getRuntimeService().setVariable(executionId, variableName, value);
    }

    @Override
    public void setVariableLocal(String executionId, String variableName, Object value) {
        this.getRuntimeService().setVariableLocal(executionId, variableName, value);
    }

    @Override
    public void setVariables(String executionId, Map<String, ?> variables) {
        this.getRuntimeService().setVariables(executionId, variables);
    }

    @Override
    public void setVariablesLocal(String executionId, Map<String, ?> variables) {
        this.getRuntimeService().setVariablesLocal(executionId, variables);
    }

    @Override
    public void removeVariable(String executionId, String variableName) {
        this.getRuntimeService().removeVariable(executionId, variableName);
    }

    @Override
    public void removeVariableLocal(String executionId, String variableName) {
        this.getRuntimeService().removeVariableLocal(executionId, variableName);
    }

    @Override
    public void removeVariables(String executionId, Collection<String> variableNames) {
        this.getRuntimeService().removeVariables(executionId, variableNames);
    }

    @Override
    public void removeVariablesLocal(String executionId, Collection<String> variableNames) {
        this.getRuntimeService().removeVariablesLocal(executionId, variableNames);
    }

    @Override
    public Map<String, DataObject> getDataObjects(String executionId) {
        return this.getRuntimeService().getDataObjects(executionId);
    }

    @Override
    public Map<String, DataObject> getDataObjects(String executionId, String locale, boolean withLocalizationFallback) {
        return this.getRuntimeService().getDataObjects(executionId, locale, withLocalizationFallback);
    }

    @Override
    public Map<String, DataObject> getDataObjectsLocal(String executionId) {
        return this.getRuntimeService().getDataObjectsLocal(executionId);
    }

    @Override
    public Map<String, DataObject> getDataObjectsLocal(String executionId, String locale, boolean withLocalizationFallback) {
        return this.getRuntimeService().getDataObjectsLocal(executionId, locale, withLocalizationFallback);
    }

    @Override
    public Map<String, DataObject> getDataObjects(String executionId, Collection<String> dataObjectNames) {
        return this.getRuntimeService().getDataObjects(executionId, dataObjectNames);
    }

    @Override
    public Map<String, DataObject> getDataObjects(String executionId, Collection<String> dataObjectNames, String locale, boolean withLocalizationFallback) {
        return this.getRuntimeService().getDataObjects(executionId, dataObjectNames, locale, withLocalizationFallback);
    }

    @Override
    public Map<String, DataObject> getDataObjectsLocal(String executionId, Collection<String> dataObjects) {
        return this.getRuntimeService().getDataObjectsLocal(executionId, dataObjects);
    }

    @Override
    public Map<String, DataObject> getDataObjectsLocal(String executionId, Collection<String> dataObjectNames, String locale, boolean withLocalizationFallback) {
        return this.getRuntimeService().getDataObjectsLocal(executionId, dataObjectNames, locale, withLocalizationFallback);
    }

    @Override
    public DataObject getDataObject(String executionId, String dataObject) {
        return this.getRuntimeService().getDataObject(executionId, dataObject);
    }

    @Override
    public DataObject getDataObject(String executionId, String dataObjectName, String locale, boolean withLocalizationFallback) {
        return this.getRuntimeService().getDataObject(executionId, dataObjectName, locale, withLocalizationFallback);
    }

    @Override
    public DataObject getDataObjectLocal(String executionId, String dataObjectName) {
        return this.getRuntimeService().getDataObjectLocal(executionId, dataObjectName);
    }

    @Override
    public DataObject getDataObjectLocal(String executionId, String dataObjectName, String locale, boolean withLocalizationFallback) {
        return this.getRuntimeService().getDataObjectLocal(executionId, dataObjectName, locale, withLocalizationFallback);
    }

    @Override
    public ExecutionQuery createExecutionQuery() {
        return this.getRuntimeService().createExecutionQuery();
    }

    @Override
    public NativeExecutionQuery createNativeExecutionQuery() {
        return this.getRuntimeService().createNativeExecutionQuery();
    }

    @Override
    public ProcessInstanceQuery createProcessInstanceQuery() {
        return this.getRuntimeService().createProcessInstanceQuery();
    }

    @Override
    public NativeProcessInstanceQuery createNativeProcessInstanceQuery() {
        return this.getRuntimeService().createNativeProcessInstanceQuery();
    }

    @Override
    public ActivityInstanceQuery createActivityInstanceQuery() {
        return this.getRuntimeService().createActivityInstanceQuery();
    }

    @Override
    public NativeActivityInstanceQuery createNativeActivityInstanceQuery() {
        return this.getRuntimeService().createNativeActivityInstanceQuery();
    }

    @Override
    public EventSubscriptionQuery createEventSubscriptionQuery() {
        return this.getRuntimeService().createEventSubscriptionQuery();
    }

    @Override
    public void suspendProcessInstanceById(String processInstanceId) {
        this.getRuntimeService().suspendProcessInstanceById(processInstanceId);
    }

    @Override
    public void activateProcessInstanceById(String processInstanceId) {
        this.getRuntimeService().activateProcessInstanceById(processInstanceId);
    }

    @Override
    public void signalEventReceived(String signalName) {
        this.getRuntimeService().signalEventReceived(signalName);
    }

    @Override
    public void signalEventReceivedWithTenantId(String signalName, String tenantId) {
        this.getRuntimeService().signalEventReceivedWithTenantId(signalName, tenantId);
    }

    @Override
    public void signalEventReceivedAsync(String signalName) {
        this.getRuntimeService().signalEventReceivedAsync(signalName);
    }

    @Override
    public void signalEventReceivedAsyncWithTenantId(String signalName, String tenantId) {
        this.getRuntimeService().signalEventReceivedAsyncWithTenantId(signalName, tenantId);
    }

    @Override
    public void signalEventReceived(String signalName, Map<String, Object> processVariables) {
        this.getRuntimeService().signalEventReceived(signalName, processVariables);
    }

    @Override
    public void signalEventReceivedWithTenantId(String signalName, Map<String, Object> processVariables, String tenantId) {
        this.getRuntimeService().signalEventReceivedWithTenantId(signalName, processVariables, tenantId);
    }

    @Override
    public void signalEventReceived(String signalName, String executionId) {
        this.getRuntimeService().signalEventReceived(signalName, executionId);
    }

    @Override
    public void signalEventReceived(String signalName, String executionId, Map<String, Object> processVariables) {
        this.getRuntimeService().signalEventReceived(signalName, executionId, processVariables);
    }

    @Override
    public void signalEventReceivedAsync(String signalName, String executionId) {
        this.getRuntimeService().signalEventReceivedAsync(signalName, executionId);
    }

    @Override
    public void messageEventReceived(String messageName, String executionId) {
        this.getRuntimeService().messageEventReceived(messageName, executionId);
    }

    @Override
    public void messageEventReceived(String messageName, String executionId, Map<String, Object> processVariables) {
        this.getRuntimeService().messageEventReceived(messageName, executionId, processVariables);
    }

    @Override
    public void messageEventReceivedAsync(String messageName, String executionId) {
        this.getRuntimeService().messageEventReceivedAsync(messageName, executionId);
    }

    @Override
    public void addEventListener(FlowableEventListener listenerToAdd) {
        this.getRuntimeService().addEventListener(listenerToAdd);
    }

    @Override
    public void addEventListener(FlowableEventListener listenerToAdd, FlowableEngineEventType... types) {
        this.getRuntimeService().addEventListener(listenerToAdd, types);
    }

    @Override
    public void removeEventListener(FlowableEventListener listenerToRemove) {
        this.getRuntimeService().removeEventListener(listenerToRemove);
    }

    @Override
    public void dispatchEvent(FlowableEvent event) {
        this.getRuntimeService().dispatchEvent(event);
    }

    @Override
    public void addEventRegistryConsumer(EventRegistryEventConsumer eventConsumer) {
        this.getRuntimeService().addEventRegistryConsumer(eventConsumer);
    }

    @Override
    public void removeEventRegistryConsumer(EventRegistryEventConsumer eventConsumer) {
        this.getRuntimeService().removeEventRegistryConsumer(eventConsumer);
    }

    @Override
    public void setProcessInstanceName(String processInstanceId, String name) {
        this.getRuntimeService().setProcessInstanceName(processInstanceId, name);
    }

    @Override
    public List<Execution> getAdhocSubProcessExecutions(String processInstanceId) {
        return this.getRuntimeService().getAdhocSubProcessExecutions(processInstanceId);
    }

    @Override
    public List<FlowNode> getEnabledActivitiesFromAdhocSubProcess(String executionId) {
        return this.getRuntimeService().getEnabledActivitiesFromAdhocSubProcess(executionId);
    }

    @Override
    public Execution executeActivityInAdhocSubProcess(String executionId, String activityId) {
        return this.getRuntimeService().executeActivityInAdhocSubProcess(executionId, activityId);
    }

    @Override
    public void completeAdhocSubProcess(String executionId) {
        this.getRuntimeService().completeAdhocSubProcess(executionId);
    }

    @Override
    public ChangeActivityStateBuilder createChangeActivityStateBuilder() {
        return this.getRuntimeService().createChangeActivityStateBuilder();
    }

    @Override
    public Execution addMultiInstanceExecution(String activityId, String parentExecutionId, Map<String, Object> executionVariables) {
        return this.getRuntimeService().addMultiInstanceExecution(activityId, parentExecutionId, executionVariables);
    }

    @Override
    public void deleteMultiInstanceExecution(String executionId, boolean executionIsCompleted) {
        this.getRuntimeService().deleteMultiInstanceExecution(executionId, executionIsCompleted);
    }

    @Override
    public List<Event> getProcessInstanceEvents(String processInstanceId) {
        return this.getRuntimeService().getProcessInstanceEvents(processInstanceId);
    }
}

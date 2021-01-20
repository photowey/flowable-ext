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

package com.photowey.ext.core.dynamic.bpmn;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.flowable.engine.DynamicBpmnService;
import org.flowable.engine.dynamic.DynamicProcessDefinitionSummary;
import org.flowable.engine.impl.dynamic.DynamicEmbeddedSubProcessBuilder;
import org.flowable.engine.impl.dynamic.DynamicUserTaskBuilder;

import java.util.List;

/**
 * {@code AbstractDynamicBpmnServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/20
 * @since 1.0.0
 */
public abstract class AbstractDynamicBpmnServiceDelegate implements DynamicBpmnService {

    public abstract DynamicBpmnService getDynamicBpmnService();

    @Override
    public void injectUserTaskInProcessInstance(String processInstanceId, DynamicUserTaskBuilder dynamicUserTaskBuilder) {
        this.getDynamicBpmnService().injectUserTaskInProcessInstance(processInstanceId, dynamicUserTaskBuilder);
    }

    @Override
    public void injectParallelUserTask(String taskId, DynamicUserTaskBuilder dynamicUserTaskBuilder) {
        this.getDynamicBpmnService().injectParallelUserTask(taskId, dynamicUserTaskBuilder);
    }

    @Override
    public void injectEmbeddedSubProcessInProcessInstance(String processInstanceId, DynamicEmbeddedSubProcessBuilder dynamicEmbeddedSubProcessBuilder) {
        this.getDynamicBpmnService().injectEmbeddedSubProcessInProcessInstance(processInstanceId, dynamicEmbeddedSubProcessBuilder);
    }

    @Override
    public void injectParallelEmbeddedSubProcess(String taskId, DynamicEmbeddedSubProcessBuilder dynamicEmbeddedSubProcessBuilder) {
        this.getDynamicBpmnService().injectParallelEmbeddedSubProcess(taskId, dynamicEmbeddedSubProcessBuilder);
    }

    @Override
    public ObjectNode getProcessDefinitionInfo(String processDefinitionId) {
        return this.getDynamicBpmnService().getProcessDefinitionInfo(processDefinitionId);
    }

    @Override
    public void saveProcessDefinitionInfo(String processDefinitionId, ObjectNode infoNode) {
        this.getDynamicBpmnService().saveProcessDefinitionInfo(processDefinitionId, infoNode);
    }

    @Override
    public ObjectNode changeServiceTaskClassName(String id, String className) {
        return this.getDynamicBpmnService().changeServiceTaskClassName(id, className);
    }

    @Override
    public void changeServiceTaskClassName(String id, String className, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeServiceTaskClassName(id, className, infoNode);
    }

    @Override
    public ObjectNode changeServiceTaskExpression(String id, String expression) {
        return this.getDynamicBpmnService().changeServiceTaskExpression(id, expression);
    }

    @Override
    public void changeServiceTaskExpression(String id, String expression, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeServiceTaskExpression(id, expression, infoNode);
    }

    @Override
    public ObjectNode changeServiceTaskDelegateExpression(String id, String expression) {
        return this.getDynamicBpmnService().changeServiceTaskDelegateExpression(id, expression);
    }

    @Override
    public void changeServiceTaskDelegateExpression(String id, String expression, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeServiceTaskDelegateExpression(id, expression, infoNode);
    }

    @Override
    public ObjectNode changeScriptTaskScript(String id, String script) {
        return this.getDynamicBpmnService().changeScriptTaskScript(id, script);
    }

    @Override
    public void changeScriptTaskScript(String id, String script, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeScriptTaskScript(id, script, infoNode);
    }

    @Override
    public ObjectNode changeSkipExpression(String id, String skipExpression) {
        return this.getDynamicBpmnService().changeSkipExpression(id, skipExpression);
    }

    @Override
    public void changeSkipExpression(String id, String skipExpression, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeSkipExpression(id, skipExpression, infoNode);
    }

    @Override
    public void removeSkipExpression(String id, ObjectNode infoNode) {
        this.getDynamicBpmnService().removeSkipExpression(id, infoNode);
    }

    @Override
    public ObjectNode enableSkipExpression() {
        return this.getDynamicBpmnService().enableSkipExpression();
    }

    @Override
    public void enableSkipExpression(ObjectNode infoNode) {
        this.getDynamicBpmnService().enableSkipExpression(infoNode);
    }

    @Override
    public void removeEnableSkipExpression(ObjectNode infoNode) {
        this.getDynamicBpmnService().removeEnableSkipExpression(infoNode);
    }

    @Override
    public ObjectNode changeUserTaskName(String id, String name) {
        return this.getDynamicBpmnService().changeUserTaskName(id, name);
    }

    @Override
    public void changeUserTaskName(String id, String name, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskName(id, name, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskDescription(String id, String description) {
        return this.getDynamicBpmnService().changeUserTaskDescription(id, description);
    }

    @Override
    public void changeUserTaskDescription(String id, String description, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskDescription(id, description, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskDueDate(String id, String dueDate) {
        return this.getDynamicBpmnService().changeUserTaskDueDate(id, dueDate);
    }

    @Override
    public void changeUserTaskDueDate(String id, String dueDate, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskDueDate(id, dueDate, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskPriority(String id, String priority) {
        return this.getDynamicBpmnService().changeUserTaskPriority(id, priority);
    }

    @Override
    public void changeUserTaskPriority(String id, String priority, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskPriority(id, priority, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskCategory(String id, String category) {
        return this.getDynamicBpmnService().changeUserTaskCategory(id, category);
    }

    @Override
    public void changeUserTaskCategory(String id, String category, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskCategory(id, category, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskFormKey(String id, String formKey) {
        return this.getDynamicBpmnService().changeUserTaskFormKey(id, formKey);
    }

    @Override
    public void changeUserTaskFormKey(String id, String formKey, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskFormKey(id, formKey, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskAssignee(String id, String assignee) {
        return this.getDynamicBpmnService().changeUserTaskAssignee(id, assignee);
    }

    @Override
    public void changeUserTaskAssignee(String id, String assignee, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskAssignee(id, assignee, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskOwner(String id, String owner) {
        return this.getDynamicBpmnService().changeUserTaskOwner(id, owner);
    }

    @Override
    public void changeUserTaskOwner(String id, String owner, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskOwner(id, owner, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskCandidateUser(String id, String candidateUser, boolean overwriteOtherChangedEntries) {
        return this.getDynamicBpmnService().changeUserTaskCandidateUser(id, candidateUser, overwriteOtherChangedEntries);
    }

    @Override
    public void changeUserTaskCandidateUser(String id, String candidateUser, boolean overwriteOtherChangedEntries, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskCandidateUser(id, candidateUser, overwriteOtherChangedEntries, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskCandidateGroup(String id, String candidateGroup, boolean overwriteOtherChangedEntries) {
        return this.getDynamicBpmnService().changeUserTaskCandidateGroup(id, candidateGroup, overwriteOtherChangedEntries);
    }

    @Override
    public void changeUserTaskCandidateGroup(String id, String candidateGroup, boolean overwriteOtherChangedEntries, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskCandidateGroup(id, candidateGroup, overwriteOtherChangedEntries, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskCandidateUsers(String id, List<String> candidateUsers) {
        return this.getDynamicBpmnService().changeUserTaskCandidateUsers(id, candidateUsers);
    }

    @Override
    public void changeUserTaskCandidateUsers(String id, List<String> candidateUsers, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskCandidateUsers(id, candidateUsers, infoNode);
    }

    @Override
    public ObjectNode changeUserTaskCandidateGroups(String id, List<String> candidateGroups) {
        return this.getDynamicBpmnService().changeUserTaskCandidateGroups(id, candidateGroups);
    }

    @Override
    public void changeUserTaskCandidateGroups(String id, List<String> candidateGroups, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeUserTaskCandidateGroups(id, candidateGroups, infoNode);
    }

    @Override
    public ObjectNode changeMultiInstanceCompletionCondition(String id, String completionCondition) {
        return this.getDynamicBpmnService().changeMultiInstanceCompletionCondition(id, completionCondition);
    }

    @Override
    public void changeMultiInstanceCompletionCondition(String id, String completionCondition, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeMultiInstanceCompletionCondition(id, completionCondition, infoNode);
    }

    @Override
    public ObjectNode changeDmnTaskDecisionTableKey(String id, String decisionTableKey) {
        return this.getDynamicBpmnService().changeDmnTaskDecisionTableKey(id, decisionTableKey);
    }

    @Override
    public void changeDmnTaskDecisionTableKey(String id, String decisionTableKey, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeDmnTaskDecisionTableKey(id, decisionTableKey, infoNode);
    }

    @Override
    public ObjectNode changeSequenceFlowCondition(String id, String condition) {
        return this.getDynamicBpmnService().changeSequenceFlowCondition(id, condition);
    }

    @Override
    public void changeSequenceFlowCondition(String id, String condition, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeSequenceFlowCondition(id, condition, infoNode);
    }

    @Override
    public ObjectNode changeCallActivityCalledElement(String id, String calledElement) {
        return this.getDynamicBpmnService().changeCallActivityCalledElement(id, calledElement);
    }

    @Override
    public void changeCallActivityCalledElement(String id, String calledElement, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeCallActivityCalledElement(id, calledElement, infoNode);
    }

    @Override
    public ObjectNode getBpmnElementProperties(String id, ObjectNode infoNode) {
        return this.getDynamicBpmnService().getBpmnElementProperties(id, infoNode);
    }

    @Override
    public ObjectNode changeLocalizationName(String language, String id, String value) {
        return this.getDynamicBpmnService().changeLocalizationName(language, id, value);
    }

    @Override
    public void changeLocalizationName(String language, String id, String value, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeLocalizationName(language, id, value, infoNode);
    }

    @Override
    public ObjectNode changeLocalizationDescription(String language, String id, String value) {
        return this.getDynamicBpmnService().changeLocalizationDescription(language, id, value);
    }

    @Override
    public void changeLocalizationDescription(String language, String id, String value, ObjectNode infoNode) {
        this.getDynamicBpmnService().changeLocalizationDescription(language, id, value, infoNode);
    }

    @Override
    public ObjectNode getLocalizationElementProperties(String language, String id, ObjectNode infoNode) {
        return this.getDynamicBpmnService().getLocalizationElementProperties(language, id, infoNode);
    }

    @Override
    public void resetProperty(String elementId, String property, ObjectNode infoNode) {
        this.getDynamicBpmnService().resetProperty(elementId, property, infoNode);
    }

    @Override
    public DynamicProcessDefinitionSummary getDynamicProcessDefinitionSummary(String processDefinitionId) {
        return this.getDynamicBpmnService().getDynamicProcessDefinitionSummary(processDefinitionId);
    }
}

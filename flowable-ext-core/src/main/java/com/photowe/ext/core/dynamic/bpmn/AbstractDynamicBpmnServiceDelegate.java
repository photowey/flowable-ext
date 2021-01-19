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

package com.photowe.ext.core.dynamic.bpmn;

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

    // TODO

    @Override
    public void injectUserTaskInProcessInstance(String processInstanceId, DynamicUserTaskBuilder dynamicUserTaskBuilder) {

    }

    @Override
    public void injectParallelUserTask(String taskId, DynamicUserTaskBuilder dynamicUserTaskBuilder) {

    }

    @Override
    public void injectEmbeddedSubProcessInProcessInstance(String processInstanceId, DynamicEmbeddedSubProcessBuilder dynamicEmbeddedSubProcessBuilder) {

    }

    @Override
    public void injectParallelEmbeddedSubProcess(String taskId, DynamicEmbeddedSubProcessBuilder dynamicEmbeddedSubProcessBuilder) {

    }

    @Override
    public ObjectNode getProcessDefinitionInfo(String processDefinitionId) {
        return null;
    }

    @Override
    public void saveProcessDefinitionInfo(String processDefinitionId, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeServiceTaskClassName(String id, String className) {
        return null;
    }

    @Override
    public void changeServiceTaskClassName(String id, String className, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeServiceTaskExpression(String id, String expression) {
        return null;
    }

    @Override
    public void changeServiceTaskExpression(String id, String expression, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeServiceTaskDelegateExpression(String id, String expression) {
        return null;
    }

    @Override
    public void changeServiceTaskDelegateExpression(String id, String expression, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeScriptTaskScript(String id, String script) {
        return null;
    }

    @Override
    public void changeScriptTaskScript(String id, String script, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeSkipExpression(String id, String skipExpression) {
        return null;
    }

    @Override
    public void changeSkipExpression(String id, String skipExpression, ObjectNode infoNode) {

    }

    @Override
    public void removeSkipExpression(String id, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode enableSkipExpression() {
        return null;
    }

    @Override
    public void enableSkipExpression(ObjectNode infoNode) {

    }

    @Override
    public void removeEnableSkipExpression(ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskName(String id, String name) {
        return null;
    }

    @Override
    public void changeUserTaskName(String id, String name, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskDescription(String id, String description) {
        return null;
    }

    @Override
    public void changeUserTaskDescription(String id, String description, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskDueDate(String id, String dueDate) {
        return null;
    }

    @Override
    public void changeUserTaskDueDate(String id, String dueDate, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskPriority(String id, String priority) {
        return null;
    }

    @Override
    public void changeUserTaskPriority(String id, String priority, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskCategory(String id, String category) {
        return null;
    }

    @Override
    public void changeUserTaskCategory(String id, String category, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskFormKey(String id, String formKey) {
        return null;
    }

    @Override
    public void changeUserTaskFormKey(String id, String formKey, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskAssignee(String id, String assignee) {
        return null;
    }

    @Override
    public void changeUserTaskAssignee(String id, String assignee, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskOwner(String id, String owner) {
        return null;
    }

    @Override
    public void changeUserTaskOwner(String id, String owner, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskCandidateUser(String id, String candidateUser, boolean overwriteOtherChangedEntries) {
        return null;
    }

    @Override
    public void changeUserTaskCandidateUser(String id, String candidateUser, boolean overwriteOtherChangedEntries, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskCandidateGroup(String id, String candidateGroup, boolean overwriteOtherChangedEntries) {
        return null;
    }

    @Override
    public void changeUserTaskCandidateGroup(String id, String candidateGroup, boolean overwriteOtherChangedEntries, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskCandidateUsers(String id, List<String> candidateUsers) {
        return null;
    }

    @Override
    public void changeUserTaskCandidateUsers(String id, List<String> candidateUsers, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeUserTaskCandidateGroups(String id, List<String> candidateGroups) {
        return null;
    }

    @Override
    public void changeUserTaskCandidateGroups(String id, List<String> candidateGroups, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeMultiInstanceCompletionCondition(String id, String completionCondition) {
        return null;
    }

    @Override
    public void changeMultiInstanceCompletionCondition(String id, String completionCondition, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeDmnTaskDecisionTableKey(String id, String decisionTableKey) {
        return null;
    }

    @Override
    public void changeDmnTaskDecisionTableKey(String id, String decisionTableKey, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeSequenceFlowCondition(String id, String condition) {
        return null;
    }

    @Override
    public void changeSequenceFlowCondition(String id, String condition, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeCallActivityCalledElement(String id, String calledElement) {
        return null;
    }

    @Override
    public void changeCallActivityCalledElement(String id, String calledElement, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode getBpmnElementProperties(String id, ObjectNode infoNode) {
        return null;
    }

    @Override
    public ObjectNode changeLocalizationName(String language, String id, String value) {
        return null;
    }

    @Override
    public void changeLocalizationName(String language, String id, String value, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode changeLocalizationDescription(String language, String id, String value) {
        return null;
    }

    @Override
    public void changeLocalizationDescription(String language, String id, String value, ObjectNode infoNode) {

    }

    @Override
    public ObjectNode getLocalizationElementProperties(String language, String id, ObjectNode infoNode) {
        return null;
    }

    @Override
    public void resetProperty(String elementId, String property, ObjectNode infoNode) {

    }

    @Override
    public DynamicProcessDefinitionSummary getDynamicProcessDefinitionSummary(String processDefinitionId) {
        return null;
    }
}

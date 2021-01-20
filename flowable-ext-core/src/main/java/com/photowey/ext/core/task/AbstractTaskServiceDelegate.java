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

package com.photowey.ext.core.task;

import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.DataObject;
import org.flowable.engine.task.Attachment;
import org.flowable.engine.task.Comment;
import org.flowable.engine.task.Event;
import org.flowable.form.api.FormInfo;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.task.api.*;
import org.flowable.variable.api.persistence.entity.VariableInstance;

import java.io.InputStream;
import java.util.*;

/**
 * {@code AbstractTaskServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/19
 * @since 1.0.0
 */
public abstract class AbstractTaskServiceDelegate implements TaskService {

    public abstract TaskService getTaskService();

    @Override
    public Task newTask() {
        return this.getTaskService().newTask();
    }

    @Override
    public Task newTask(String taskId) {
        return this.getTaskService().newTask(taskId);
    }

    @Override
    public TaskBuilder createTaskBuilder() {
        return this.getTaskService().createTaskBuilder();
    }

    @Override
    public TaskCompletionBuilder createTaskCompletionBuilder() {
        return this.getTaskService().createTaskCompletionBuilder();
    }

    @Override
    public void saveTask(Task task) {
        this.getTaskService().saveTask(task);
    }

    @Override
    public void deleteTask(String taskId) {
        this.getTaskService().deleteTask(taskId);
    }

    @Override
    public void deleteTasks(Collection<String> taskIds) {
        this.getTaskService().deleteTasks(taskIds);
    }

    @Override
    public void deleteTask(String taskId, boolean cascade) {
        this.getTaskService().deleteTask(taskId, cascade);
    }

    @Override
    public void deleteTasks(Collection<String> taskIds, boolean cascade) {
        this.getTaskService().deleteTasks(taskIds, cascade);
    }

    @Override
    public void deleteTask(String taskId, String deleteReason) {
        this.getTaskService().deleteTask(taskId, deleteReason);
    }

    @Override
    public void deleteTasks(Collection<String> taskIds, String deleteReason) {
        this.getTaskService().deleteTasks(taskIds, deleteReason);
    }

    @Override
    public void claim(String taskId, String userId) {
        this.getTaskService().claim(taskId, userId);
    }

    @Override
    public void unclaim(String taskId) {
        this.getTaskService().unclaim(taskId);
    }

    @Override
    public void complete(String taskId) {
        this.getTaskService().complete(taskId);
    }

    @Override
    public void delegateTask(String taskId, String userId) {
        this.getTaskService().delegateTask(taskId, userId);
    }

    @Override
    public void resolveTask(String taskId) {
        this.getTaskService().resolveTask(taskId);
    }

    @Override
    public void resolveTask(String taskId, Map<String, Object> variables) {
        this.getTaskService().resolveTask(taskId, variables);
    }

    @Override
    public void resolveTask(String taskId, Map<String, Object> variables, Map<String, Object> transientVariables) {
        this.getTaskService().resolveTask(taskId, variables, transientVariables);
    }

    @Override
    public void complete(String taskId, Map<String, Object> variables) {
        this.getTaskService().complete(taskId, variables);
    }

    @Override
    public void complete(String taskId, Map<String, Object> variables, Map<String, Object> transientVariables) {
        this.getTaskService().complete(taskId, variables, transientVariables);
    }

    @Override
    public void complete(String taskId, Map<String, Object> variables, boolean localScope) {
        this.getTaskService().complete(taskId, variables, localScope);
    }

    @Override
    public void completeTaskWithForm(String taskId, String formDefinitionId, String outcome, Map<String, Object> variables) {
        this.getTaskService().completeTaskWithForm(taskId, formDefinitionId, outcome, variables);
    }

    @Override
    public void completeTaskWithForm(String taskId, String formDefinitionId, String outcome, Map<String, Object> variables, Map<String, Object> transientVariables) {
        this.getTaskService().completeTaskWithForm(taskId, formDefinitionId, outcome, variables, transientVariables);
    }

    @Override
    public void completeTaskWithForm(String taskId, String formDefinitionId, String outcome, Map<String, Object> variables, boolean localScope) {
        this.getTaskService().completeTaskWithForm(taskId, formDefinitionId, outcome, variables, localScope);
    }

    @Override
    public FormInfo getTaskFormModel(String taskId) {
        return this.getTaskService().getTaskFormModel(taskId);
    }

    @Override
    public FormInfo getTaskFormModel(String taskId, boolean ignoreVariables) {
        return this.getTaskService().getTaskFormModel(taskId, ignoreVariables);
    }

    @Override
    public void setAssignee(String taskId, String userId) {
        this.getTaskService().setAssignee(taskId, userId);
    }

    @Override
    public void setOwner(String taskId, String userId) {
        this.getTaskService().setOwner(taskId, userId);
    }

    @Override
    public List<IdentityLink> getIdentityLinksForTask(String taskId) {
        return this.getTaskService().getIdentityLinksForTask(taskId);
    }

    @Override
    public void addCandidateUser(String taskId, String userId) {
        this.getTaskService().addCandidateUser(taskId, userId);
    }

    @Override
    public void addCandidateGroup(String taskId, String groupId) {
        this.getTaskService().addCandidateGroup(taskId, groupId);
    }

    @Override
    public void addUserIdentityLink(String taskId, String userId, String identityLinkType) {
        this.getTaskService().addUserIdentityLink(taskId, userId, identityLinkType);
    }

    @Override
    public void addGroupIdentityLink(String taskId, String groupId, String identityLinkType) {
        this.getTaskService().addGroupIdentityLink(taskId, groupId, identityLinkType);
    }

    @Override
    public void deleteCandidateUser(String taskId, String userId) {
        this.getTaskService().deleteCandidateUser(taskId, userId);
    }

    @Override
    public void deleteCandidateGroup(String taskId, String groupId) {
        this.getTaskService().deleteCandidateGroup(taskId, groupId);
    }

    @Override
    public void deleteUserIdentityLink(String taskId, String userId, String identityLinkType) {
        this.getTaskService().deleteUserIdentityLink(taskId, userId, identityLinkType);
    }

    @Override
    public void deleteGroupIdentityLink(String taskId, String groupId, String identityLinkType) {
        this.getTaskService().deleteGroupIdentityLink(taskId, groupId, identityLinkType);
    }

    @Override
    public void setPriority(String taskId, int priority) {
        this.getTaskService().setPriority(taskId, priority);
    }

    @Override
    public void setDueDate(String taskId, Date dueDate) {
        this.getTaskService().setDueDate(taskId, dueDate);
    }

    @Override
    public TaskQuery createTaskQuery() {
        return this.getTaskService().createTaskQuery();
    }

    @Override
    public NativeTaskQuery createNativeTaskQuery() {
        return this.getTaskService().createNativeTaskQuery();
    }

    @Override
    public void setVariable(String taskId, String variableName, Object value) {
        this.getTaskService().setVariable(taskId, variableName, value);
    }

    @Override
    public void setVariables(String taskId, Map<String, ?> variables) {
        this.getTaskService().setVariables(taskId, variables);
    }

    @Override
    public void setVariableLocal(String taskId, String variableName, Object value) {
        this.getTaskService().setVariableLocal(taskId, variableName, value);
    }

    @Override
    public void setVariablesLocal(String taskId, Map<String, ?> variables) {
        this.getTaskService().setVariablesLocal(taskId, variables);
    }

    @Override
    public Object getVariable(String taskId, String variableName) {
        return this.getTaskService().getVariable(taskId, variableName);
    }

    @Override
    public <T> T getVariable(String taskId, String variableName, Class<T> variableClass) {
        return this.getTaskService().getVariable(taskId, variableName, variableClass);
    }

    @Override
    public VariableInstance getVariableInstance(String taskId, String variableName) {
        return this.getTaskService().getVariableInstance(taskId, variableName);
    }

    @Override
    public boolean hasVariable(String taskId, String variableName) {
        return this.getTaskService().hasVariable(taskId, variableName);
    }

    @Override
    public Object getVariableLocal(String taskId, String variableName) {
        return this.getTaskService().getVariableLocal(taskId, variableName);
    }

    @Override
    public <T> T getVariableLocal(String taskId, String variableName, Class<T> variableClass) {
        return this.getTaskService().getVariableLocal(taskId, variableName, variableClass);
    }

    @Override
    public VariableInstance getVariableInstanceLocal(String taskId, String variableName) {
        return this.getTaskService().getVariableInstanceLocal(taskId, variableName);
    }

    @Override
    public boolean hasVariableLocal(String taskId, String variableName) {
        return this.getTaskService().hasVariableLocal(taskId, variableName);
    }

    @Override
    public Map<String, Object> getVariables(String taskId) {
        return this.getTaskService().getVariables(taskId);
    }

    @Override
    public Map<String, VariableInstance> getVariableInstances(String taskId) {
        return this.getTaskService().getVariableInstances(taskId);
    }

    @Override
    public Map<String, VariableInstance> getVariableInstances(String taskId, Collection<String> variableNames) {
        return this.getTaskService().getVariableInstances(taskId, variableNames);
    }

    @Override
    public Map<String, Object> getVariablesLocal(String taskId) {
        return this.getTaskService().getVariablesLocal(taskId);
    }

    @Override
    public Map<String, Object> getVariables(String taskId, Collection<String> variableNames) {
        return this.getTaskService().getVariables(taskId, variableNames);
    }

    @Override
    public Map<String, Object> getVariablesLocal(String taskId, Collection<String> variableNames) {
        return this.getTaskService().getVariablesLocal(taskId, variableNames);
    }

    @Override
    public List<VariableInstance> getVariableInstancesLocalByTaskIds(Set<String> taskIds) {
        return this.getTaskService().getVariableInstancesLocalByTaskIds(taskIds);
    }

    @Override
    public Map<String, VariableInstance> getVariableInstancesLocal(String taskId) {
        return this.getTaskService().getVariableInstancesLocal(taskId);
    }

    @Override
    public Map<String, VariableInstance> getVariableInstancesLocal(String taskId, Collection<String> variableNames) {
        return this.getTaskService().getVariableInstancesLocal(taskId, variableNames);
    }

    @Override
    public void removeVariable(String taskId, String variableName) {
        this.getTaskService().removeVariable(taskId, variableName);
    }

    @Override
    public void removeVariableLocal(String taskId, String variableName) {
        this.getTaskService().removeVariableLocal(taskId, variableName);
    }

    @Override
    public void removeVariables(String taskId, Collection<String> variableNames) {
        this.getTaskService().removeVariables(taskId, variableNames);
    }

    @Override
    public void removeVariablesLocal(String taskId, Collection<String> variableNames) {
        this.getTaskService().removeVariablesLocal(taskId, variableNames);
    }

    @Override
    public Map<String, DataObject> getDataObjects(String taskId) {
        return this.getTaskService().getDataObjects(taskId);
    }

    @Override
    public Map<String, DataObject> getDataObjects(String taskId, String locale, boolean withLocalizationFallback) {
        return this.getTaskService().getDataObjects(taskId, locale, withLocalizationFallback);
    }

    @Override
    public Map<String, DataObject> getDataObjects(String taskId, Collection<String> dataObjectNames) {
        return this.getTaskService().getDataObjects(taskId, dataObjectNames);
    }

    @Override
    public Map<String, DataObject> getDataObjects(String taskId, Collection<String> dataObjectNames, String locale, boolean withLocalizationFallback) {
        return this.getTaskService().getDataObjects(taskId, dataObjectNames, locale, withLocalizationFallback);
    }

    @Override
    public DataObject getDataObject(String taskId, String dataObject) {
        return this.getTaskService().getDataObject(taskId, dataObject);
    }

    @Override
    public DataObject getDataObject(String taskId, String dataObjectName, String locale, boolean withLocalizationFallback) {
        return this.getTaskService().getDataObject(taskId, dataObjectName, locale, withLocalizationFallback);
    }

    @Override
    public Comment addComment(String taskId, String processInstanceId, String message) {
        return this.getTaskService().addComment(taskId, processInstanceId, message);
    }

    @Override
    public Comment addComment(String taskId, String processInstanceId, String type, String message) {
        return this.getTaskService().addComment(taskId, processInstanceId, type, message);
    }

    @Override
    public void saveComment(Comment comment) {
        this.getTaskService().saveComment(comment);
    }

    @Override
    public Comment getComment(String getComment) {
        return this.getTaskService().getComment(getComment);
    }

    @Override
    public void deleteComments(String taskId, String processInstanceId) {
        this.getTaskService().deleteComments(taskId, processInstanceId);
    }

    @Override
    public void deleteComment(String commentId) {
        this.getTaskService().deleteComment(commentId);
    }

    @Override
    public List<Comment> getTaskComments(String taskId) {
        return this.getTaskService().getTaskComments(taskId);
    }

    @Override
    public List<Comment> getTaskComments(String taskId, String type) {
        return this.getTaskService().getTaskComments(taskId, type);
    }

    @Override
    public List<Comment> getCommentsByType(String type) {
        return this.getTaskService().getCommentsByType(type);
    }

    @Override
    public List<Event> getTaskEvents(String taskId) {
        return this.getTaskService().getTaskEvents(taskId);
    }

    @Override
    public Event getEvent(String eventId) {
        return this.getTaskService().getEvent(eventId);
    }

    @Override
    public List<Comment> getProcessInstanceComments(String processInstanceId) {
        return this.getTaskService().getProcessInstanceComments(processInstanceId);
    }

    @Override
    public List<Comment> getProcessInstanceComments(String processInstanceId, String type) {
        return this.getTaskService().getProcessInstanceComments(processInstanceId, type);
    }

    @Override
    public Attachment createAttachment(String attachmentType, String taskId, String processInstanceId, String attachmentName, String attachmentDescription, InputStream content) {
        return this.getTaskService().createAttachment(attachmentType, taskId, processInstanceId, attachmentName, attachmentDescription, content);
    }

    @Override
    public Attachment createAttachment(String attachmentType, String taskId, String processInstanceId, String attachmentName, String attachmentDescription, String url) {
        return this.getTaskService().createAttachment(attachmentType, taskId, processInstanceId, attachmentName, attachmentDescription, url);
    }

    @Override
    public void saveAttachment(Attachment attachment) {
        this.getTaskService().saveAttachment(attachment);
    }

    @Override
    public Attachment getAttachment(String attachmentId) {
        return this.getTaskService().getAttachment(attachmentId);
    }

    @Override
    public InputStream getAttachmentContent(String attachmentId) {
        return this.getTaskService().getAttachmentContent(attachmentId);
    }

    @Override
    public List<Attachment> getTaskAttachments(String taskId) {
        return this.getTaskService().getTaskAttachments(taskId);
    }

    @Override
    public List<Attachment> getProcessInstanceAttachments(String processInstanceId) {
        return this.getTaskService().getProcessInstanceAttachments(processInstanceId);
    }

    @Override
    public void deleteAttachment(String attachmentId) {
        this.getTaskService().deleteAttachment(attachmentId);
    }

    @Override
    public List<Task> getSubTasks(String parentTaskId) {
        return this.getTaskService().getSubTasks(parentTaskId);
    }
}

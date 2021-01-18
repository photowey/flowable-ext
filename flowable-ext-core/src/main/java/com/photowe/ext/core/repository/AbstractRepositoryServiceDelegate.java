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

package com.photowe.ext.core.repository;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.dmn.api.DmnDecision;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.app.AppModel;
import org.flowable.engine.repository.*;
import org.flowable.form.api.FormDefinition;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.validation.ValidationError;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * {@code AbstractRepositoryServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/19
 * @since 1.0.0
 */
public abstract class AbstractRepositoryServiceDelegate implements RepositoryService {

    /**
     * Get {@link RepositoryService} instance.
     *
     * @return {@link RepositoryService}
     */
    public abstract RepositoryService getRepositoryService();

    @Override
    public DeploymentBuilder createDeployment() {
        return this.getRepositoryService().createDeployment();
    }

    @Override
    public void deleteDeployment(String deploymentId) {
        this.getRepositoryService().deleteDeployment(deploymentId);
    }

    @Override
    public void deleteDeployment(String deploymentId, boolean cascade) {
        this.getRepositoryService().deleteDeployment(deploymentId, cascade);
    }

    @Override
    public void setDeploymentCategory(String deploymentId, String category) {
        this.getRepositoryService().setDeploymentCategory(deploymentId, category);
    }

    @Override
    public void setDeploymentKey(String deploymentId, String key) {
        this.getRepositoryService().setDeploymentKey(deploymentId, key);
    }

    @Override
    public List<String> getDeploymentResourceNames(String deploymentId) {
        return this.getRepositoryService().getDeploymentResourceNames(deploymentId);
    }

    @Override
    public InputStream getResourceAsStream(String deploymentId, String resourceName) {
        return this.getRepositoryService().getResourceAsStream(deploymentId, resourceName);
    }

    @Override
    public void changeDeploymentTenantId(String deploymentId, String newTenantId) {
        this.getRepositoryService().changeDeploymentTenantId(deploymentId, newTenantId);
    }

    @Override
    public void changeDeploymentTenantId(String deploymentId, String newTenantId, MergeMode mergeMode) {
        this.getRepositoryService().changeDeploymentTenantId(deploymentId, newTenantId, mergeMode);
    }

    @Override
    public void changeDeploymentTenantId(String deploymentId, String newTenantId, DeploymentMergeStrategy deploymentMergeStrategy) {
        this.getRepositoryService().changeDeploymentTenantId(deploymentId, newTenantId, deploymentMergeStrategy);
    }

    @Override
    public void changeDeploymentParentDeploymentId(String deploymentId, String newParentDeploymentId) {
        this.getRepositoryService().changeDeploymentParentDeploymentId(deploymentId, newParentDeploymentId);
    }

    @Override
    public ProcessDefinitionQuery createProcessDefinitionQuery() {
        return this.getRepositoryService().createProcessDefinitionQuery();
    }

    @Override
    public NativeProcessDefinitionQuery createNativeProcessDefinitionQuery() {
        return this.getRepositoryService().createNativeProcessDefinitionQuery();
    }

    @Override
    public DeploymentQuery createDeploymentQuery() {
        return this.getRepositoryService().createDeploymentQuery();
    }

    @Override
    public NativeDeploymentQuery createNativeDeploymentQuery() {
        return this.getRepositoryService().createNativeDeploymentQuery();
    }

    @Override
    public void suspendProcessDefinitionById(String processDefinitionId) {
        this.getRepositoryService().suspendProcessDefinitionById(processDefinitionId);
    }

    @Override
    public void suspendProcessDefinitionById(String processDefinitionId, boolean suspendProcessInstances, Date suspensionDate) {
        this.getRepositoryService().suspendProcessDefinitionById(processDefinitionId, suspendProcessInstances, suspensionDate);
    }

    @Override
    public void suspendProcessDefinitionByKey(String processDefinitionKey) {
        this.getRepositoryService().suspendProcessDefinitionByKey(processDefinitionKey);
    }

    @Override
    public void suspendProcessDefinitionByKey(String processDefinitionKey, boolean suspendProcessInstances, Date suspensionDate) {
        this.getRepositoryService().suspendProcessDefinitionByKey(processDefinitionKey, suspendProcessInstances, suspensionDate);
    }

    @Override
    public void suspendProcessDefinitionByKey(String processDefinitionKey, String tenantId) {
        this.getRepositoryService().suspendProcessDefinitionByKey(processDefinitionKey, tenantId);
    }

    @Override
    public void suspendProcessDefinitionByKey(String processDefinitionKey, boolean suspendProcessInstances, Date suspensionDate, String tenantId) {
        this.getRepositoryService().suspendProcessDefinitionByKey(processDefinitionKey, suspendProcessInstances, suspensionDate, tenantId);
    }

    @Override
    public void activateProcessDefinitionById(String processDefinitionId) {
        this.getRepositoryService().activateProcessDefinitionById(processDefinitionId);
    }

    @Override
    public void activateProcessDefinitionById(String processDefinitionId, boolean activateProcessInstances, Date activationDate) {
        this.getRepositoryService().activateProcessDefinitionById(processDefinitionId, activateProcessInstances, activationDate);
    }

    @Override
    public void activateProcessDefinitionByKey(String processDefinitionKey) {
        this.getRepositoryService().activateProcessDefinitionByKey(processDefinitionKey);
    }

    @Override
    public void activateProcessDefinitionByKey(String processDefinitionKey, boolean activateProcessInstances, Date activationDate) {
        this.getRepositoryService().activateProcessDefinitionByKey(processDefinitionKey, activateProcessInstances, activationDate);
    }

    @Override
    public void activateProcessDefinitionByKey(String processDefinitionKey, String tenantId) {
        this.getRepositoryService().activateProcessDefinitionByKey(processDefinitionKey, tenantId);
    }

    @Override
    public void activateProcessDefinitionByKey(String processDefinitionKey, boolean activateProcessInstances, Date activationDate, String tenantId) {
        this.getRepositoryService().activateProcessDefinitionByKey(processDefinitionKey, activateProcessInstances, activationDate, tenantId);
    }

    @Override
    public void setProcessDefinitionCategory(String processDefinitionId, String category) {
        this.getRepositoryService().setProcessDefinitionCategory(processDefinitionId, category);
    }

    @Override
    public InputStream getProcessModel(String processDefinitionId) {
        return this.getRepositoryService().getProcessModel(processDefinitionId);
    }

    @Override
    public InputStream getProcessDiagram(String processDefinitionId) {
        return this.getRepositoryService().getProcessDiagram(processDefinitionId);
    }

    @Override
    public ProcessDefinition getProcessDefinition(String processDefinitionId) {
        return this.getRepositoryService().getProcessDefinition(processDefinitionId);
    }

    @Override
    public Boolean isFlowable5ProcessDefinition(String processDefinitionId) {
        return this.getRepositoryService().isFlowable5ProcessDefinition(processDefinitionId);
    }

    @Override
    public boolean isProcessDefinitionSuspended(String processDefinitionId) {
        return this.getRepositoryService().isProcessDefinitionSuspended(processDefinitionId);
    }

    @Override
    public BpmnModel getBpmnModel(String processDefinitionId) {
        return this.getRepositoryService().getBpmnModel(processDefinitionId);
    }

    @Override
    public DiagramLayout getProcessDiagramLayout(String processDefinitionId) {
        return this.getRepositoryService().getProcessDiagramLayout(processDefinitionId);
    }

    @Override
    public Object getAppResourceObject(String deploymentId) {
        return this.getRepositoryService().getAppResourceObject(deploymentId);
    }

    @Override
    public AppModel getAppResourceModel(String deploymentId) {
        return this.getRepositoryService().getAppResourceModel(deploymentId);
    }

    @Override
    public Model newModel() {
        return this.getRepositoryService().newModel();
    }

    @Override
    public void saveModel(Model model) {
        this.getRepositoryService().saveModel(model);
    }

    @Override
    public void deleteModel(String modelId) {
        this.getRepositoryService().deleteModel(modelId);
    }

    @Override
    public void addModelEditorSource(String modelId, byte[] bytes) {
        this.getRepositoryService().addModelEditorSource(modelId, bytes);
    }

    @Override
    public void addModelEditorSourceExtra(String modelId, byte[] bytes) {
        this.getRepositoryService().addModelEditorSourceExtra(modelId, bytes);
    }

    @Override
    public ModelQuery createModelQuery() {
        return this.getRepositoryService().createModelQuery();
    }

    @Override
    public NativeModelQuery createNativeModelQuery() {
        return this.getRepositoryService().createNativeModelQuery();
    }

    @Override
    public Model getModel(String modelId) {
        return this.getRepositoryService().getModel(modelId);
    }

    @Override
    public byte[] getModelEditorSource(String modelId) {
        return this.getRepositoryService().getModelEditorSource(modelId);
    }

    @Override
    public byte[] getModelEditorSourceExtra(String modelId) {
        return this.getRepositoryService().getModelEditorSourceExtra(modelId);
    }

    @Override
    public void addCandidateStarterUser(String processDefinitionId, String userId) {
        this.getRepositoryService().addCandidateStarterUser(processDefinitionId, userId);
    }

    @Override
    public void addCandidateStarterGroup(String processDefinitionId, String groupId) {
        this.getRepositoryService().addCandidateStarterGroup(processDefinitionId, groupId);
    }

    @Override
    public void deleteCandidateStarterUser(String processDefinitionId, String userId) {
        this.getRepositoryService().deleteCandidateStarterUser(processDefinitionId, userId);
    }

    @Override
    public void deleteCandidateStarterGroup(String processDefinitionId, String groupId) {
        this.getRepositoryService().deleteCandidateStarterGroup(processDefinitionId, groupId);
    }

    @Override
    public List<IdentityLink> getIdentityLinksForProcessDefinition(String processDefinitionId) {
        return this.getRepositoryService().getIdentityLinksForProcessDefinition(processDefinitionId);
    }

    @Override
    public List<ValidationError> validateProcess(BpmnModel bpmnModel) {
        return this.getRepositoryService().validateProcess(bpmnModel);
    }

    @Override
    public List<DmnDecision> getDecisionsForProcessDefinition(String processDefinitionId) {
        return this.getRepositoryService().getDecisionsForProcessDefinition(processDefinitionId);
    }

    /**
     * Retrieves the {@link DmnDecision}s associated with the given process definition.
     *
     * @param processDefinitionId id of the process definition, cannot be null.
     * @deprecated replaced by getDecisionsForProcessDefinition(String processDefinitionId)
     */
    @Override
    public List<DmnDecision> getDecisionTablesForProcessDefinition(String processDefinitionId) {
        return this.getRepositoryService().getDecisionTablesForProcessDefinition(processDefinitionId);
    }

    @Override
    public List<FormDefinition> getFormDefinitionsForProcessDefinition(String processDefinitionId) {
        return this.getRepositoryService().getFormDefinitionsForProcessDefinition(processDefinitionId);
    }
}

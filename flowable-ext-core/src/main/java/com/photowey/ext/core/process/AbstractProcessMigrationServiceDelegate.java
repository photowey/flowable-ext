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

package com.photowey.ext.core.process;

import org.flowable.batch.api.Batch;
import org.flowable.engine.ProcessMigrationService;
import org.flowable.engine.migration.ProcessInstanceBatchMigrationResult;
import org.flowable.engine.migration.ProcessInstanceMigrationBuilder;
import org.flowable.engine.migration.ProcessInstanceMigrationDocument;
import org.flowable.engine.migration.ProcessInstanceMigrationValidationResult;

/**
 * {@code AbstractProcessMigrationServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/19
 * @since 1.0.0
 */
public abstract class AbstractProcessMigrationServiceDelegate implements ProcessMigrationService {

    public abstract ProcessMigrationService getProcessMigrationService();

    @Override
    public ProcessInstanceMigrationBuilder createProcessInstanceMigrationBuilder() {
        return this.getProcessMigrationService().createProcessInstanceMigrationBuilder();
    }

    @Override
    public ProcessInstanceMigrationBuilder createProcessInstanceMigrationBuilderFromProcessInstanceMigrationDocument(ProcessInstanceMigrationDocument document) {
        return this.getProcessMigrationService().createProcessInstanceMigrationBuilderFromProcessInstanceMigrationDocument(document);
    }

    @Override
    public ProcessInstanceMigrationValidationResult validateMigrationForProcessInstance(
            String processInstanceId, ProcessInstanceMigrationDocument processInstanceMigrationDocument) {
        return this.getProcessMigrationService().validateMigrationForProcessInstance(
                processInstanceId, processInstanceMigrationDocument);
    }

    @Override
    public ProcessInstanceMigrationValidationResult validateMigrationForProcessInstancesOfProcessDefinition(
            String processDefinitionId, ProcessInstanceMigrationDocument processInstanceMigrationDocument) {
        return this.getProcessMigrationService().validateMigrationForProcessInstancesOfProcessDefinition(
                processDefinitionId, processInstanceMigrationDocument);
    }

    @Override
    public ProcessInstanceMigrationValidationResult validateMigrationForProcessInstancesOfProcessDefinition(
            String processDefinitionKey, int processDefinitionVersion, String processDefinitionTenantId, ProcessInstanceMigrationDocument processInstanceMigrationDocument) {
        return this.getProcessMigrationService().validateMigrationForProcessInstancesOfProcessDefinition(
                processDefinitionKey, processDefinitionVersion, processDefinitionTenantId, processInstanceMigrationDocument);
    }

    @Override
    public void migrateProcessInstance(String processInstanceId, ProcessInstanceMigrationDocument processInstanceMigrationDocument) {
        this.getProcessMigrationService().migrateProcessInstancesOfProcessDefinition(processInstanceId, processInstanceMigrationDocument);
    }

    @Override
    public void migrateProcessInstancesOfProcessDefinition(String processDefinitionId, ProcessInstanceMigrationDocument processInstanceMigrationDocument) {
        this.getProcessMigrationService().migrateProcessInstancesOfProcessDefinition(processDefinitionId, processInstanceMigrationDocument);
    }

    @Override
    public void migrateProcessInstancesOfProcessDefinition(String processDefinitionKey, int processDefinitionVersion,
                                                           String processDefinitionTenantId, ProcessInstanceMigrationDocument processInstanceMigrationDocument) {
        this.getProcessMigrationService().migrateProcessInstancesOfProcessDefinition(processDefinitionKey,
                processDefinitionVersion, processDefinitionTenantId, processInstanceMigrationDocument);
    }

    @Override
    public Batch batchMigrateProcessInstancesOfProcessDefinition(String processDefinitionId, ProcessInstanceMigrationDocument processInstanceMigrationDocument) {
        return this.getProcessMigrationService().batchMigrateProcessInstancesOfProcessDefinition(processDefinitionId, processInstanceMigrationDocument);
    }

    @Override
    public Batch batchMigrateProcessInstancesOfProcessDefinition(String processDefinitionKey, int processDefinitionVersion,
                                                                 String processDefinitionTenantId, ProcessInstanceMigrationDocument processInstanceMigrationDocument) {
        return this.getProcessMigrationService().batchMigrateProcessInstancesOfProcessDefinition(
                processDefinitionKey, processDefinitionVersion, processDefinitionTenantId, processInstanceMigrationDocument);
    }

    @Override
    public ProcessInstanceBatchMigrationResult getResultsOfBatchProcessInstanceMigration(String migrationBatchId) {
        return this.getProcessMigrationService().getResultsOfBatchProcessInstanceMigration(migrationBatchId);
    }
}

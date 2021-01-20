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

package com.photowey.ext.core.management;

import org.flowable.batch.api.Batch;
import org.flowable.batch.api.BatchBuilder;
import org.flowable.batch.api.BatchPart;
import org.flowable.batch.api.BatchQuery;
import org.flowable.common.engine.api.management.TableMetaData;
import org.flowable.common.engine.api.management.TablePageQuery;
import org.flowable.common.engine.impl.cmd.CustomSqlExecution;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandConfig;
import org.flowable.common.engine.impl.lock.LockManager;
import org.flowable.engine.ManagementService;
import org.flowable.engine.event.EventLogEntry;
import org.flowable.engine.runtime.ExternalWorkerCompletionBuilder;
import org.flowable.job.api.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * {@code AbstractManagementServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/19
 * @since 1.0.0
 */
public abstract class AbstractManagementServiceDelegate implements ManagementService {

    public abstract ManagementService getManagementService();

    @Override
    public Map<String, Long> getTableCount() {
        return null;
    }

    @Override
    public String getTableName(Class<?> entityClass) {
        return null;
    }

    @Override
    public String getTableName(Class<?> entityClass, boolean includePrefix) {
        return null;
    }

    @Override
    public TableMetaData getTableMetaData(String tableName) {
        return null;
    }

    @Override
    public TablePageQuery createTablePageQuery() {
        return null;
    }

    @Override
    public JobQuery createJobQuery() {
        return null;
    }

    @Override
    public ExternalWorkerJobQuery createExternalWorkerJobQuery() {
        return null;
    }

    @Override
    public TimerJobQuery createTimerJobQuery() {
        return null;
    }

    @Override
    public SuspendedJobQuery createSuspendedJobQuery() {
        return null;
    }

    @Override
    public DeadLetterJobQuery createDeadLetterJobQuery() {
        return null;
    }

    @Override
    public HistoryJobQuery createHistoryJobQuery() {
        return null;
    }

    @Override
    public Job findJobByCorrelationId(String jobCorrelationId) {
        return null;
    }

    @Override
    public void executeJob(String jobId) {

    }

    @Override
    public void executeHistoryJob(String historyJobId) {

    }

    @Override
    public String getHistoryJobHistoryJson(String historyJobId) {
        return null;
    }

    @Override
    public Job moveTimerToExecutableJob(String jobId) {
        return null;
    }

    @Override
    public Job moveJobToDeadLetterJob(String jobId) {
        return null;
    }

    @Override
    public Job moveDeadLetterJobToExecutableJob(String jobId, int retries) {
        return null;
    }

    @Override
    public HistoryJob moveDeadLetterJobToHistoryJob(String jobId, int retries) {
        return null;
    }

    @Override
    public Job moveSuspendedJobToExecutableJob(String jobId) {
        return null;
    }

    @Override
    public void deleteJob(String jobId) {

    }

    @Override
    public void deleteTimerJob(String jobId) {

    }

    @Override
    public void deleteSuspendedJob(String jobId) {

    }

    @Override
    public void deleteDeadLetterJob(String jobId) {

    }

    @Override
    public void deleteExternalWorkerJob(String jobId) {

    }

    @Override
    public void deleteHistoryJob(String jobId) {

    }

    @Override
    public void setJobRetries(String jobId, int retries) {

    }

    @Override
    public void setTimerJobRetries(String jobId, int retries) {

    }

    @Override
    public Job rescheduleTimeDateJob(String jobId, String timeDate) {
        return null;
    }

    @Override
    public Job rescheduleTimeDurationJob(String jobId, String timeDuration) {
        return null;
    }

    @Override
    public Job rescheduleTimeCycleJob(String jobId, String timeCycle) {
        return null;
    }

    @Override
    public Job rescheduleTimerJob(String jobId, String timeDate, String timeDuration, String timeCycle, String endDate, String calendarName) {
        return null;
    }

    @Override
    public String getJobExceptionStacktrace(String jobId) {
        return null;
    }

    @Override
    public String getTimerJobExceptionStacktrace(String jobId) {
        return null;
    }

    @Override
    public String getSuspendedJobExceptionStacktrace(String jobId) {
        return null;
    }

    @Override
    public String getDeadLetterJobExceptionStacktrace(String jobId) {
        return null;
    }

    @Override
    public String getExternalWorkerJobErrorDetails(String jobId) {
        return null;
    }

    @Override
    public void handleHistoryCleanupTimerJob() {

    }

    @Override
    public List<Batch> getAllBatches() {
        return null;
    }

    @Override
    public List<Batch> findBatchesBySearchKey(String searchKey) {
        return null;
    }

    @Override
    public String getBatchDocument(String batchId) {
        return null;
    }

    @Override
    public BatchPart getBatchPart(String batchPartId) {
        return null;
    }

    @Override
    public List<BatchPart> findBatchPartsByBatchId(String batchId) {
        return null;
    }

    @Override
    public List<BatchPart> findBatchPartsByBatchIdAndStatus(String batchId, String status) {
        return null;
    }

    @Override
    public String getBatchPartDocument(String batchPartId) {
        return null;
    }

    @Override
    public BatchQuery createBatchQuery() {
        return null;
    }

    @Override
    public BatchBuilder createBatchBuilder() {
        return null;
    }

    @Override
    public void deleteBatch(String batchId) {

    }

    @Override
    public Map<String, String> getProperties() {
        return null;
    }

    @Override
    public String databaseSchemaUpgrade(Connection connection, String catalog, String schema) {
        return null;
    }

    @Override
    public <T> T executeCommand(Command<T> command) {
        return null;
    }

    @Override
    public <T> T executeCommand(CommandConfig config, Command<T> command) {
        return null;
    }

    @Override
    public LockManager getLockManager(String lockName) {
        return null;
    }

    @Override
    public <MapperType, ResultType> ResultType executeCustomSql(CustomSqlExecution<MapperType, ResultType> customSqlExecution) {
        return null;
    }

    @Override
    public List<EventLogEntry> getEventLogEntries(Long startLogNr, Long pageSize) {
        return null;
    }

    @Override
    public List<EventLogEntry> getEventLogEntriesByProcessInstanceId(String processInstanceId) {
        return null;
    }

    @Override
    public void deleteEventLogEntry(long logNr) {

    }

    @Override
    public ExternalWorkerJobAcquireBuilder createExternalWorkerJobAcquireBuilder() {
        return null;
    }

    @Override
    public ExternalWorkerJobFailureBuilder createExternalWorkerJobFailureBuilder(String externalJobId, String workerId) {
        return null;
    }

    @Override
    public ExternalWorkerCompletionBuilder createExternalWorkerCompletionBuilder(String externalJobId, String workerId) {
        return null;
    }
}

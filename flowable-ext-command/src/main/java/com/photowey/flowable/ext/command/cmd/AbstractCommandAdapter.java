package com.photowey.flowable.ext.command.cmd;

import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;
import com.photowey.flowable.ext.plugin.api.feature.Feature;

/**
 * {@code AbstractCommandAdapter} in an abstract class, that can be implemented by real command.
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public abstract class AbstractCommandAdapter<T extends AbstractCommandContext, R> implements Command<T, R> {

    /**
     * Init the command
     *
     * @param context the command context
     */
    protected void init(T context) {
        // TODO Do nothing, sub-classes may override
    }

    /**
     * Pre the Inspect
     *
     * @param context the command context
     */
    protected void preInspect(T context) {
        // TODO Do nothing, sub-classes may override
    }

    /**
     * Post the Inspect
     *
     * @param context the command context
     */
    protected void postInspect(T context) {
        // TODO Do nothing, sub-classes may override
    }

    /**
     * Pre the Rule
     *
     * @param context the command context
     */
    protected void preRule(T context) {
        // TODO Do nothing, sub-classes may override
    }

    /**
     * Post the Rule
     *
     * @param context the command context
     */
    protected void postRule(T context) {
        // TODO Do nothing, sub-classes may override
    }

    /**
     * Pre the Storage
     *
     * @param context the command context
     */
    protected void preStorage(T context) {
        // TODO Do nothing, sub-classes may override
    }

    /**
     * Post the Storage
     *
     * @param context the command context
     */
    protected void postStorage(T context) {
        // TODO Do nothing, sub-classes may override
    }

    /**
     * Handle the command execute result.
     *
     * @return R the result, may not be the final result of the command execution
     */
    protected abstract R handleCommand();

    @Override
    public R execute(T context) {
        // Init the command
        this.init(context);

        Feature feature = context.getFeature();

        // Apply Feature
        this.preInspect(context);
        feature.getInspector().inspect(context);
        this.postInspect(context);

        // Apply Rule
        this.preRule(context);
        feature.getRule().apply(context);
        this.postRule(context);

        // Apply Storage
        this.preStorage(context);
        feature.getStorage().save(context);
        this.postStorage(context);

        return this.handleCommand();
    }
}

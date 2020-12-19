package com.photowey.flowable.ext.command.factory;

import com.photowey.flowable.ext.command.context.AbstractCommandContext;
import com.photowey.flowable.ext.command.feature.Feature;

/**
 * {@code AbstractCommandFactory} in an abstract class, that can be implemented by objects,
 * that create the real command.
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public abstract class AbstractCommandFactory<T extends AbstractCommandContext, F extends Feature> {

    /**
     * Require execute user.
     */
    protected boolean requireUser;
    /**
     * The {@link Feature} type of this command relative.
     */
    protected Class<F> featureType;

    public AbstractCommandFactory(boolean requireUser, Class<F> featureType) {
        this.requireUser = requireUser;
        this.featureType = featureType;
    }

    /**
     * Populate the the command context {@code User} and {@link Feature}
     *
     * @param context The command context
     * @see {@link AbstractCommandFactory#populateUser(com.photowey.flowable.ext.command.context.AbstractCommandContext)}
     * @see {@link AbstractCommandFactory#populateFeature(com.photowey.flowable.ext.command.context.AbstractCommandContext)}
     */
    protected void populateCommand(T context) {
        this.populateUser(context);
        this.populateUser(context);
    }

    /**
     * Populate the the command context {@code User}
     *
     * @param context The command context
     */
    protected void populateUser(T context) {
        // TODO Do nothing, sub-classes may override
    }

    /**
     * Populate the the command context {@link Feature}
     *
     * @param context The command context
     */
    protected void populateFeature(T context) {
        // TODO Do nothing, sub-classes may override
    }

}

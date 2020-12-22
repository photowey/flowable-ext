package com.photowey.flowable.ext.plugin.api.rule;

import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

/**
 * {@code Rule} is an interface that can be implemented by objects,
 * and guide specific business execution
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface Rule<T extends AbstractCommandContext> {

    /**
     * Apply the business rules
     * If anyone return {@code false}, the current action will be interrupted, and return {@code false}
     *
     * @param context The command context
     * @return {@code boolean}
     */
    boolean apply(T context);
}

package com.photowey.flowable.ext.command.storage;

import com.photowey.flowable.ext.command.context.AbstractCommandContext;

/**
 * Storage
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
@FunctionalInterface
public interface Storage<T extends AbstractCommandContext> {

    /**
     * Save the business data image, if necessary.
     * If anyone return {@code false}, the current action will be interrupted, and return {@code false}
     *
     * @param context The command context
     * @return {@code boolean}
     */
    boolean save(T context);
}

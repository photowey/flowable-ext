package com.photowey.flowable.ext.plugin.api.storage;

import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

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

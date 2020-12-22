package com.photowey.flowable.ext.plugin.api.inspector;

import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

/**
 * Inspector
 * <p>
 * If the one {@link Inspector} implements the {@link com.photowey.flowable.ext.plugin.api.order.Ordered},
 * that will be execute before the plain {@link Inspector}
 * <p>
 * {@link com.photowey.flowable.ext.plugin.api.order.PriorityOrdered} > {@link com.photowey.flowable.ext.plugin.api.order.Ordered > plain {@link Inspector}
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
@FunctionalInterface
public interface Inspector<T extends AbstractCommandContext> {

    /**
     * Inspect the environment of execute the command.
     * If anyone {@link Inspector} return {@code false}, the execute command action will be interrupted, and return.
     *
     * @param context The command context.
     * @return {@code boolean}
     */
    boolean inspect(T context);
}

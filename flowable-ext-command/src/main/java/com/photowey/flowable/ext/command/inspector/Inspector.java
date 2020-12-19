package com.photowey.flowable.ext.command.inspector;

import com.photowey.flowable.ext.command.context.AbstractCommandContext;
import com.photowey.flowable.ext.command.order.Ordered;
import com.photowey.flowable.ext.command.order.PriorityOrdered;

/**
 * Inspector
 * <p>
 * If the one {@link Inspector} implements the {@link Ordered},
 * that will be execute before the plain {@link Inspector}
 * <p>
 * {@link PriorityOrdered} > {@link Ordered} > plain {@link Inspector}
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

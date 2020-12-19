package com.photowey.flowable.ext.command.cmd;

import com.photowey.flowable.ext.command.context.AbstractCommandContext;

/**
 * {@code Command} is an interface that can be implemented by objects
 *
 * @param <T> The T type Context
 * @param <R> The command execute result R type
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
@FunctionalInterface
public interface Command<T extends AbstractCommandContext, R> {

    /**
     * Execute the Command with context that extends {@link AbstractCommandContext}.
     *
     * @param context The command context
     * @return The command execute result R type
     */
    R execute(T context);
}

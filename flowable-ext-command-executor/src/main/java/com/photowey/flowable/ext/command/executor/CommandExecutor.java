package com.photowey.flowable.ext.command.executor;

import com.photowey.flowable.ext.command.cmd.Command;
import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

/**
 * CommandExecutor
 *
 * @author photowey
 * @date 2020/12/27
 * @since 1.0.0
 */
public interface CommandExecutor<T extends AbstractCommandContext, R> {

    /**
     * execution the {@link Command}
     *
     * @param command the command
     * @param context the command context
     * @return R type
     */
    R execute(Command<T, R> command, T context);
}

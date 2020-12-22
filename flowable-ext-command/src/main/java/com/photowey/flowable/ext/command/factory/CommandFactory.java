package com.photowey.flowable.ext.command.factory;

import com.photowey.flowable.ext.command.cmd.Command;
import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

/**
 * {@code CommandFactory} is an interface that can be implemented by real command factory,
 * that create the real command.
 *
 * @param <T> The context
 * @param <C> The command
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface CommandFactory<T extends AbstractCommandContext, C extends Command<T, ?>> {

    /**
     * Create the context.
     *
     * @return the command context, T type.
     */
    T createContext();

    /**
     * Create the command
     *
     * @return the command, C type
     */
    C createCommand();

}

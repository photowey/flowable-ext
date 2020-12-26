package com.photowey.flowable.ext.command.executor.factory;

import com.photowey.flowable.ext.command.executor.cmd.TestCommandContext;

/**
 * TestCommandContextFactory
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public class TestCommandContextFactory {

    /**
     * Create TestCommandContext
     *
     * @return {@link TestCommandContext}
     */
    public static TestCommandContext createTestCommandContext() {
        return new TestCommandContext();
    }

}

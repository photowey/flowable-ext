package com.photowey.flowable.ext.command.executor;

import com.photowey.flowable.ext.command.executor.cmd.TestCommand;
import com.photowey.flowable.ext.command.executor.cmd.TestCommandContext;
import com.photowey.flowable.ext.command.executor.factory.TestCommandFactory;
import com.photowey.flowable.ext.command.executor.payload.TestPayload;
import org.junit.jupiter.api.Test;

/**
 * DefaultCommandExecutorTest
 *
 * @author photowey
 * @date 2020/12/27
 * @since 1.0.0
 */
public class DefaultCommandExecutorTest {

    @Test
    public void testExecuteCommand() {
        TestPayload payload = new TestPayload("shark-chili");

        TestCommandFactory testCommandFactory = new TestCommandFactory(true, payload);
        TestCommandContext context = testCommandFactory.createContext();
        TestCommand command = testCommandFactory.createCommand();

        DefaultCommandExecutor<TestCommandContext, Void> commandExecutor = new DefaultCommandExecutor<>();
        commandExecutor.execute(command, context);
    }

}
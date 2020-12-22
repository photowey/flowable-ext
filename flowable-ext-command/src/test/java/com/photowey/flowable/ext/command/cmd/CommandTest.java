package com.photowey.flowable.ext.command.cmd;

import com.photowey.flowable.ext.command.factory.TestCommandFactory;
import com.photowey.flowable.ext.command.payload.TestPayload;
import org.junit.jupiter.api.Test;

/**
 * CommandTest
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public class CommandTest {

    @Test
    public void testCommand() {
        TestPayload payload = new TestPayload("shark-chili");

        TestCommandFactory testCommandFactory = new TestCommandFactory(true, payload);
        TestCommandContext context = testCommandFactory.createContext();
        TestCommand command = testCommandFactory.createCommand();
        command.execute(context);
    }

}

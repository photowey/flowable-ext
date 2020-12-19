package com.photowey.flowable.ext.command.factory;

import com.photowey.flowable.ext.command.cmd.TestCommand;
import com.photowey.flowable.ext.command.context.TestCommandContext;
import com.photowey.flowable.ext.command.feature.TestFeature;
import com.photowey.flowable.ext.command.payload.TestPayload;

/**
 * TestCommandFactory
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestCommandFactory extends AbstractCommandFactory<TestCommandContext, TestFeature>
        implements CommandFactory<TestCommandContext, TestCommand> {

    public TestCommandFactory(boolean requireUser, TestPayload testPayload) {
        super(requireUser, TestFeature.class);
    }

    @Override
    protected void populateCommand(TestCommandContext context) {
        super.populateCommand(context);
    }

    @Override
    protected void populateUser(TestCommandContext context) {
        super.populateUser(context);
    }

    @Override
    protected void populateFeature(TestCommandContext context) {
        super.populateFeature(context);
    }

    @Override
    public TestCommandContext createContext() {
        TestCommandContext testCommandContext = TestCommandContextFactory.createTestCommandContext();
        this.populateCommand(testCommandContext);
        return testCommandContext;
    }

    @Override
    public TestCommand createCommand() {
        return new TestCommand();
    }
}

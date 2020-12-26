package com.photowey.flowable.ext.command.executor.cmd;

import com.photowey.flowable.ext.command.cmd.AbstractCommandAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestCommand
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public class TestCommand extends AbstractCommandAdapter<TestCommandContext, Void> {

    private static final Logger log = LoggerFactory.getLogger(TestCommand.class);

    @Override
    protected void init(TestCommandContext context) {
        super.init(context);
    }

    @Override
    protected void preInspect(TestCommandContext context) {
        super.preInspect(context);
    }

    @Override
    protected void postInspect(TestCommandContext context) {
        super.postInspect(context);
    }

    @Override
    protected void preRule(TestCommandContext context) {
        super.preRule(context);
    }

    @Override
    protected void postRule(TestCommandContext context) {
        super.postRule(context);
    }

    @Override
    protected void preStorage(TestCommandContext context) {
        super.preStorage(context);
    }

    @Override
    protected void postStorage(TestCommandContext context) {
        super.postStorage(context);
    }

    @Override
    protected Void handleCommand() {
        return null;
    }

    @Override
    public Void execute(TestCommandContext context) {
        return super.execute(context);
    }
}

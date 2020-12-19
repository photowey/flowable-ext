package com.photowey.flowable.ext.command.rule;

import com.photowey.flowable.ext.command.context.TestCommandContext;

/**
 * RuleComposite
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestRule implements Rule<TestCommandContext> {

    @Override
    public boolean apply(TestCommandContext context) {
        return true;
    }
}

package com.photowey.flowable.ext.command.rule;

import com.photowey.flowable.ext.command.context.TestCommandContext;

import java.util.ArrayList;
import java.util.List;

/**
 * TestRuleComposite
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestRuleComposite implements Rule<TestCommandContext> {

    private List<Rule<TestCommandContext>> delegates = new ArrayList<>();

    @Override
    public boolean apply(TestCommandContext context) {
        for (Rule<TestCommandContext> delegate : this.delegates) {
            if (!delegate.apply(context)) {
                return false;
            }
        }

        return true;
    }

    public void registerRule(Rule<TestCommandContext> candidate) {
        this.delegates.add(candidate);
    }
}

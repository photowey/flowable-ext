package com.photowey.flowable.ext.command.rule;

import com.photowey.flowable.ext.command.context.TestCommandContext;
import com.photowey.flowable.ext.command.order.Ordered;
import com.photowey.flowable.ext.command.order.PriorityOrdered;
import com.photowey.flowable.ext.core.util.LambdaUtils;

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
        // Priority Ordered
        List<Rule<TestCommandContext>> priorityRules = LambdaUtils.filter(delegates,
                delegate -> PriorityOrdered.class.isAssignableFrom(delegate.getClass()));
        if (priorityRules.size() > 0) {
            for (Rule<TestCommandContext> delegate : priorityRules) {
                if (!delegate.apply(context)) {
                    return false;
                }
            }
        }

        // Plain Ordered
        List<Rule<TestCommandContext>> plainOrderedRules = LambdaUtils.filter(delegates,
                delegate -> Ordered.class.isAssignableFrom(delegate.getClass()));
        // Remove: priority ordered
        plainOrderedRules.removeAll(priorityRules);

        if (plainOrderedRules.size() > 0) {
            for (Rule<TestCommandContext> delegate : plainOrderedRules) {
                if (!delegate.apply(context)) {
                    return false;
                }
            }
        }

        List<Rule<TestCommandContext>> normalRules = LambdaUtils.copy(this.delegates);
        if (priorityRules.size() > 0) {
            normalRules.removeAll(priorityRules);
        }
        if (plainOrderedRules.size() > 0) {
            normalRules.removeAll(plainOrderedRules);
        }

        for (Rule<TestCommandContext> delegate : normalRules) {
            if (!delegate.apply(context)) {
                return false;
            }
        }

        return true;
    }

    public void registerRule(Rule<TestCommandContext> delegate) {
        this.delegates.add(delegate);
    }
}

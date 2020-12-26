/*
 * Copyright © 2020 photowey (photowey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.photowey.flowable.ext.command.rule;

import com.photowey.flowable.ext.command.cmd.TestCommandContext;
import com.photowey.flowable.ext.common.util.LambdaUtils;
import com.photowey.flowable.ext.plugin.api.order.Ordered;
import com.photowey.flowable.ext.plugin.api.order.PriorityOrdered;
import com.photowey.flowable.ext.plugin.api.rule.Rule;

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

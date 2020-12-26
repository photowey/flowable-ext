package com.photowey.flowable.ext.command.executor.inspector;

import com.photowey.flowable.ext.command.executor.cmd.TestCommandContext;
import com.photowey.flowable.ext.common.util.LambdaUtils;
import com.photowey.flowable.ext.plugin.api.inspector.Inspector;
import com.photowey.flowable.ext.plugin.api.order.Ordered;
import com.photowey.flowable.ext.plugin.api.order.PriorityOrdered;

import java.util.ArrayList;
import java.util.List;

/**
 * TestInspectorComposite
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestInspectorComposite implements Inspector<TestCommandContext> {

    private List<Inspector<TestCommandContext>> delegates = new ArrayList<>();

    @Override
    public boolean inspect(TestCommandContext context) {
        // Priority Ordered
        List<Inspector<TestCommandContext>> priorityInspectors = LambdaUtils.filter(this.delegates,
                delegate -> PriorityOrdered.class.isAssignableFrom(delegate.getClass()));
        if (priorityInspectors.size() > 0) {
            for (Inspector<TestCommandContext> delegate : priorityInspectors) {
                if (!delegate.inspect(context)) {
                    return false;
                }
            }
        }

        // Plain Ordered
        List<Inspector<TestCommandContext>> plainOrderedInspectors = LambdaUtils.filter(this.delegates,
                delegate -> Ordered.class.isAssignableFrom(delegate.getClass()));
        // Remove: priority ordered
        plainOrderedInspectors.removeAll(priorityInspectors);

        if (plainOrderedInspectors.size() > 0) {
            for (Inspector<TestCommandContext> delegate : plainOrderedInspectors) {
                if (!delegate.inspect(context)) {
                    return false;
                }
            }
        }

        List<Inspector<TestCommandContext>> normalInspectors = LambdaUtils.copy(this.delegates);
        if (priorityInspectors.size() > 0) {
            normalInspectors.removeAll(priorityInspectors);
        }
        if (plainOrderedInspectors.size() > 0) {
            normalInspectors.removeAll(plainOrderedInspectors);
        }

        for (Inspector<TestCommandContext> delegate : normalInspectors) {
            if (!delegate.inspect(context)) {
                return false;
            }
        }

        return true;
    }

    public void registerInspector(Inspector<TestCommandContext> delegate) {
        this.delegates.add(delegate);
    }
}

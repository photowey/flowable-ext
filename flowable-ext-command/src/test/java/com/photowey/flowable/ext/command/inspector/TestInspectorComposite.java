package com.photowey.flowable.ext.command.inspector;

import com.photowey.flowable.ext.command.context.TestCommandContext;

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
        for (Inspector<TestCommandContext> delegate : this.delegates) {
            if (!delegate.inspect(context)) {
                return false;
            }
        }

        return true;
    }

    public void registerInspector(Inspector<TestCommandContext> candidate) {
        this.delegates.add(candidate);
    }
}

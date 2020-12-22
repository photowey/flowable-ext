package com.photowey.flowable.ext.command.inspector;

import com.photowey.flowable.ext.command.cmd.TestCommandContext;
import com.photowey.flowable.ext.plugin.api.inspector.Inspector;

/**
 * TestInspector
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestInspector implements Inspector<TestCommandContext> {

    @Override
    public boolean inspect(TestCommandContext context) {
        return true;
    }
}

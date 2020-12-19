package com.photowey.flowable.ext.command.storage;

import com.photowey.flowable.ext.command.context.TestCommandContext;

/**
 * TestStorage
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestStorage implements Storage<TestCommandContext> {

    @Override
    public boolean save(TestCommandContext context) {
        return true;
    }
}

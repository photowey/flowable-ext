package com.photowey.flowable.ext.command.storage;

import com.photowey.flowable.ext.command.cmd.TestCommandContext;
import com.photowey.flowable.ext.plugin.api.storage.Storage;

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

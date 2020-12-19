package com.photowey.flowable.ext.command.storage;

import com.photowey.flowable.ext.command.context.TestCommandContext;

import java.util.ArrayList;
import java.util.List;

/**
 * StorageComposite
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestStorageComposite implements Storage<TestCommandContext> {

    private List<Storage<TestCommandContext>> delegates = new ArrayList<>();

    @Override
    public boolean save(TestCommandContext context) {

        for (Storage<TestCommandContext> delegate : this.delegates) {
            if (!delegate.save(context)) {
                return false;
            }
        }

        return true;
    }

    public void registerStorage(Storage<TestCommandContext> storage) {
        this.delegates.add(storage);
    }
}

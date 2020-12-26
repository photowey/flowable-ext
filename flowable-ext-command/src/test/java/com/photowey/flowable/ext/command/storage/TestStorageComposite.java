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

package com.photowey.flowable.ext.command.storage;

import com.photowey.flowable.ext.command.cmd.TestCommandContext;
import com.photowey.flowable.ext.common.util.LambdaUtils;
import com.photowey.flowable.ext.plugin.api.order.Ordered;
import com.photowey.flowable.ext.plugin.api.order.PriorityOrdered;
import com.photowey.flowable.ext.plugin.api.storage.Storage;

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
        // Priority Ordered
        List<Storage<TestCommandContext>> priorityStorages = LambdaUtils.filter(delegates,
                delegate -> PriorityOrdered.class.isAssignableFrom(delegate.getClass()));
        if (priorityStorages.size() > 0) {
            for (Storage<TestCommandContext> delegate : priorityStorages) {
                if (!delegate.save(context)) {
                    return false;
                }
            }
        }

        // Plain Ordered
        List<Storage<TestCommandContext>> plainOrderedStorages = LambdaUtils.filter(delegates,
                delegate -> Ordered.class.isAssignableFrom(delegate.getClass()));
        // Remove: priority ordered
        plainOrderedStorages.removeAll(priorityStorages);

        if (plainOrderedStorages.size() > 0) {
            for (Storage<TestCommandContext> delegate : plainOrderedStorages) {
                if (!delegate.save(context)) {
                    return false;
                }
            }
        }

        List<Storage<TestCommandContext>> normalStorages = LambdaUtils.copy(this.delegates);
        if (priorityStorages.size() > 0) {
            normalStorages.removeAll(priorityStorages);
        }
        if (plainOrderedStorages.size() > 0) {
            normalStorages.removeAll(plainOrderedStorages);
        }

        for (Storage<TestCommandContext> delegate : normalStorages) {
            if (!delegate.save(context)) {
                return false;
            }
        }

        return true;
    }

    public void registerStorage(Storage<TestCommandContext> delegate) {
        this.delegates.add(delegate);
    }
}

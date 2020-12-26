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

package com.photowey.flowable.ext.command.feature;

import com.photowey.flowable.ext.command.cmd.TestCommandContext;
import com.photowey.flowable.ext.plugin.api.feature.Feature;
import com.photowey.flowable.ext.plugin.api.inspector.Inspector;
import com.photowey.flowable.ext.plugin.api.rule.Rule;
import com.photowey.flowable.ext.plugin.api.storage.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * TestFeatureComposite
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestFeatureComposite implements Feature<TestCommandContext> {

    private List<Feature<TestCommandContext>> delegates = new ArrayList<>();

    @Override
    public Inspector<TestCommandContext> getInspector() {
        // TODO ordered
        for (Feature<TestCommandContext> delegate : delegates) {
            Inspector<TestCommandContext> candidate = delegate.getInspector();
            if (null != candidate) {
                return candidate;
            }
        }

        return null;
    }

    @Override
    public Rule<TestCommandContext> getRule() {
        // TODO ordered
        for (Feature<TestCommandContext> delegate : delegates) {
            Rule<TestCommandContext> candidate = delegate.getRule();
            if (null != candidate) {
                return candidate;
            }
        }

        return null;
    }

    @Override
    public Storage<TestCommandContext> getStorage() {
        // TODO ordered
        for (Feature<TestCommandContext> delegate : delegates) {
            Storage<TestCommandContext> candidate = delegate.getStorage();
            if (null != candidate) {
                return candidate;
            }
        }

        return null;
    }

    public void registerFeature(Feature<TestCommandContext> candidate) {
        this.delegates.add(candidate);
    }
}

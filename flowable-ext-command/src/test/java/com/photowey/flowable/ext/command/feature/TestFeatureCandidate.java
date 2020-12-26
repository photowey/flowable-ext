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
import com.photowey.flowable.ext.command.inspector.TestInspectorComposite;
import com.photowey.flowable.ext.command.rule.TestRuleComposite;
import com.photowey.flowable.ext.command.storage.TestStorageComposite;
import com.photowey.flowable.ext.plugin.api.feature.Feature;
import com.photowey.flowable.ext.plugin.api.inspector.Inspector;
import com.photowey.flowable.ext.plugin.api.rule.Rule;
import com.photowey.flowable.ext.plugin.api.storage.Storage;

/**
 * TestFeatureCandidate
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestFeatureCandidate implements Feature<TestCommandContext> {

    private TestInspectorComposite inspectorComposite;
    private TestRuleComposite ruleComposite;
    private TestStorageComposite testStorageComposite;

    public TestFeatureCandidate() {
    }

    public TestFeatureCandidate(TestInspectorComposite inspectorComposite, TestRuleComposite ruleComposite, TestStorageComposite testStorageComposite) {
        this.inspectorComposite = inspectorComposite;
        this.ruleComposite = ruleComposite;
        this.testStorageComposite = testStorageComposite;
    }

    public TestInspectorComposite getInspectorComposite() {
        return inspectorComposite;
    }

    public void setInspectorComposite(TestInspectorComposite inspectorComposite) {
        this.inspectorComposite = inspectorComposite;
    }

    public TestRuleComposite getRuleComposite() {
        return ruleComposite;
    }

    public void setRuleComposite(TestRuleComposite ruleComposite) {
        this.ruleComposite = ruleComposite;
    }

    public TestStorageComposite getTestStorageComposite() {
        return testStorageComposite;
    }

    public void setTestStorageComposite(TestStorageComposite testStorageComposite) {
        this.testStorageComposite = testStorageComposite;
    }

    @Override
    public Inspector<TestCommandContext> getInspector() {
        return this.getInspectorComposite();
    }

    @Override
    public Rule<TestCommandContext> getRule() {
        return this.getRuleComposite();
    }

    @Override
    public Storage<TestCommandContext> getStorage() {
        return this.getTestStorageComposite();
    }
}

package com.photowey.flowable.ext.command.feature;

import com.photowey.flowable.ext.command.context.TestCommandContext;
import com.photowey.flowable.ext.command.inspector.Inspector;
import com.photowey.flowable.ext.command.inspector.TestInspectorComposite;
import com.photowey.flowable.ext.command.rule.Rule;
import com.photowey.flowable.ext.command.rule.TestRuleComposite;
import com.photowey.flowable.ext.command.storage.Storage;
import com.photowey.flowable.ext.command.storage.TestStorageComposite;

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

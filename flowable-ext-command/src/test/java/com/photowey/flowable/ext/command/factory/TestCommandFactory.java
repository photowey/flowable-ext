package com.photowey.flowable.ext.command.factory;

import com.photowey.flowable.ext.command.cmd.TestCommand;
import com.photowey.flowable.ext.command.context.TestCommandContext;
import com.photowey.flowable.ext.command.feature.TestFeature;
import com.photowey.flowable.ext.command.feature.TestFeatureCandidate;
import com.photowey.flowable.ext.command.feature.TestFeatureComposite;
import com.photowey.flowable.ext.command.inspector.TestInspector;
import com.photowey.flowable.ext.command.inspector.TestInspectorComposite;
import com.photowey.flowable.ext.command.payload.TestPayload;
import com.photowey.flowable.ext.command.rule.TestRule;
import com.photowey.flowable.ext.command.rule.TestRuleComposite;
import com.photowey.flowable.ext.command.storage.TestStorage;
import com.photowey.flowable.ext.command.storage.TestStorageComposite;

/**
 * TestCommandFactory
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestCommandFactory extends AbstractCommandFactory<TestCommandContext, TestFeature>
        implements CommandFactory<TestCommandContext, TestCommand> {

    public TestCommandFactory(boolean requireUser, TestPayload testPayload) {
        super(requireUser, TestFeature.class);
    }

    @Override
    protected void populateCommand(TestCommandContext context) {
        super.populateCommand(context);
    }

    @Override
    protected void populateUser(TestCommandContext context) {
        super.populateUser(context);
    }

    @Override
    protected void populateFeature(TestCommandContext context) {
        super.populateFeature(context);

        TestInspector testInspector = new TestInspector();
        TestRule testRule = new TestRule();
        TestStorage testStorage = new TestStorage();

        TestFeatureComposite testFeatureComposite = new TestFeatureComposite();

        TestRuleComposite testRuleComposite = new TestRuleComposite();
        TestStorageComposite storageComposite = new TestStorageComposite();
        TestInspectorComposite testInspectorComposite = new TestInspectorComposite();

        testRuleComposite.registerRule(testRule);
        storageComposite.registerStorage(testStorage);
        testInspectorComposite.registerInspector(testInspector);

        TestFeatureCandidate testFeatureCandidate = new TestFeatureCandidate(testInspectorComposite, testRuleComposite, storageComposite);
        testFeatureComposite.registerFeature(testFeatureCandidate);

        // This {@link TestFeature} may be from another one , such as the plugins.
        // {@code TestFeatureCandidate} just a demo, how to use.
        context.setFeature(testFeatureComposite);

    }

    @Override
    public TestCommandContext createContext() {
        TestCommandContext testCommandContext = TestCommandContextFactory.createTestCommandContext();
        this.populateCommand(testCommandContext);
        return testCommandContext;
    }

    @Override
    public TestCommand createCommand() {
        return new TestCommand();
    }
}

package com.photowey.flowable.ext.command.cmd;

import com.photowey.flowable.ext.command.context.TestCommandContext;
import com.photowey.flowable.ext.command.factory.TestCommandFactory;
import com.photowey.flowable.ext.command.feature.TestFeatureCandidate;
import com.photowey.flowable.ext.command.feature.TestFeatureComposite;
import com.photowey.flowable.ext.command.inspector.TestInspector;
import com.photowey.flowable.ext.command.inspector.TestInspectorComposite;
import com.photowey.flowable.ext.command.payload.TestPayload;
import com.photowey.flowable.ext.command.rule.TestRule;
import com.photowey.flowable.ext.command.rule.TestRuleComposite;
import com.photowey.flowable.ext.command.storage.TestStorage;
import com.photowey.flowable.ext.command.storage.TestStorageComposite;
import org.junit.jupiter.api.Test;

/**
 * CommandTest
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public class CommandTest {

    @Test
    public void testCommand() {
        TestPayload payload = new TestPayload("shark-chili");

        TestCommandFactory testCommandFactory = new TestCommandFactory(true, payload);
        TestCommandContext context = testCommandFactory.createContext();
        TestCommand command = testCommandFactory.createCommand();

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

        context.setFeature(testFeatureComposite);

        command.execute(context);
    }

}

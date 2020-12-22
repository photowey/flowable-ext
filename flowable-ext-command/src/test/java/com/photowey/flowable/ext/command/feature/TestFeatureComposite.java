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

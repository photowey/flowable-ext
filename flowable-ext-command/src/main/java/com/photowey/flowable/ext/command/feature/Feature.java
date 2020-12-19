package com.photowey.flowable.ext.command.feature;

import com.photowey.flowable.ext.command.context.AbstractCommandContext;
import com.photowey.flowable.ext.command.inspector.Inspector;
import com.photowey.flowable.ext.command.rule.Rule;
import com.photowey.flowable.ext.command.storage.Storage;

/**
 * {@code Feature} is an interface that can be implemented by objects.
 * A {@code Feature} include {@link Inspector}, {@link Rule} and {@link Storage}
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface Feature<T extends AbstractCommandContext> {

    /**
     * Get the {@link Inspector}.
     */
    default Inspector<T> getInspector() {
        return null;
    }

    /**
     * Get the {@link Rule}.
     */
    default Rule<T> getRule() {
        return null;
    }

    /**
     * Get the {@link Storage}.
     */
    default Storage<T> getStorage() {
        return null;
    }
}

package com.photowey.flowable.ext.command.order;

/**
 * Extension of the {@link Ordered} interface.
 * {@code PriorityOrdered} objects are always applied before
 * plain {@link Ordered} objects regardless of their order values.
 * <p>
 * The design idea comes from Springframework
 * {@code org.springframework.core.PriorityOrdered}
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface PriorityOrdered extends Ordered {
}

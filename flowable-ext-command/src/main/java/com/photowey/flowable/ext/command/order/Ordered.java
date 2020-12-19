package com.photowey.flowable.ext.command.order;

/**
 * {@code Ordered} is an interface that can be implemented by objects
 * that should be ordered.
 * <p>
 * The design idea comes from Springframework
 * {@code org.springframework.core.Ordered}
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public interface Ordered {

    /**
     * Useful constant for the highest precedence value.
     *
     * @see java.lang.Integer#MIN_VALUE
     */
    int HIGHEST_PRECEDENCE = Integer.MIN_VALUE;

    /**
     * Useful constant for the lowest precedence value.
     *
     * @see java.lang.Integer#MAX_VALUE
     */
    int LOWEST_PRECEDENCE = Integer.MAX_VALUE;

    /**
     * Get the order value of this object.
     * <p>
     * Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    int getOrder();
}

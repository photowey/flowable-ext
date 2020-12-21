package com.photowey.flowable.ext.core.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Lambda Utils
 *
 * @author photowey
 * @date 2020/12/21
 * @since 1.0.0
 */
public final class LambdaUtils {

    private LambdaUtils() {
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    public static <T, D> List<D> transferToList(Collection<T> resources, Function<T, D> function) {
        return resources.stream().map(function::apply).collect(Collectors.toList());
    }

    public static <T, D> Set<D> transferToSet(Collection<T> resources, Function<T, D> function) {
        return resources.stream().map(function::apply).collect(Collectors.toSet());
    }

    public static <T, D> D findAny(Collection<T> resources, Function<T, D> function) {
        return resources.stream().map(function::apply).findAny().orElse(null);
    }

    public static <T> List<T> filter(Collection<T> resources, Predicate<? super T> predicate) {
        return resources.stream().filter(predicate::test).collect(Collectors.toList());
    }

    public static <T> T filterAny(Collection<T> resources, Predicate<T> predicate) {
        return resources.stream().filter(predicate::test).findAny().orElse(null);
    }

    public static <T> boolean test(T resource, Predicate predicate) {
        return predicate.test(resource);
    }

    public static <T> List<T> copy(Collection<T> delegates) {
        List<T> copy = delegates.stream().map(delegate -> delegate).collect(Collectors.toList());
        return copy;
    }
}

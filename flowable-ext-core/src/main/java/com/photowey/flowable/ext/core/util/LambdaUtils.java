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

    public static <T, D> List<D> transferList(Collection<T> resources, Function<T, D> function) {
        return resources.stream().map(function::apply).collect(Collectors.toList());
    }

    public static <T, D> Set<D> transferSet(Collection<T> resources, Function<T, D> function) {
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

    public static <T, D> List<D> filterAndTransfer(Collection<T> contractFinances, Predicate<? super T> predicate, Function<T, D> function) {
        return contractFinances.stream().filter(predicate::test).map(function::apply).collect(Collectors.toList());
    }

    public static <T, D> List<D> multiFilterAndTransfer(Collection<T> contractFinances, Predicate<? super T> predicate1, Predicate<? super T> predicate2, Function<T, D> function) {
        return contractFinances.stream().filter(predicate1::test).filter(predicate2::test).map(function::apply).collect(Collectors.toList());
    }

    public static <T, D> Set<D> filterAndTransferSet(Collection<T> contractFinances, Predicate<? super T> predicate, Function<T, D> function) {
        return contractFinances.stream().filter(predicate::test).map(function::apply).collect(Collectors.toSet());
    }

    public static <T, D> Set<D> multiFilterAndTransferSet(Collection<T> contractFinances, Predicate<? super T> predicate1, Predicate<? super T> predicate2, Function<T, D> function) {
        return contractFinances.stream().filter(predicate1::test).filter(predicate2::test).map(function::apply).collect(Collectors.toSet());
    }

    public static <T> boolean test(T resource, Predicate predicate) {
        return predicate.test(resource);
    }
}

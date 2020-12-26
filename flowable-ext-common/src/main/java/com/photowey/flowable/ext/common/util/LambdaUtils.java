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

package com.photowey.flowable.ext.common.util;

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

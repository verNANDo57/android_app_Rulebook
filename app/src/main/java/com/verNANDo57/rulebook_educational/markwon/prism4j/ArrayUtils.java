/*
 * Author: noties <https://noties.io/>
 * date: 2019/06/11
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.prism4j;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class ArrayUtils {

    @SafeVarargs
    @NotNull
    static <T> List<T> toList(T... args) {
        final int length = args != null
                ? args.length
                : 0;
        final List<T> list = new ArrayList<>(length);
        if (length > 0) {
            Collections.addAll(list, args);
        }
        return list;
    }

    private ArrayUtils() {
    }
}

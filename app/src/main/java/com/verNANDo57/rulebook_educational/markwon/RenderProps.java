/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @since 3.0.0
 */
public interface RenderProps {

    @Nullable
    <T> T get(@NonNull Prop<T> prop);

    @NonNull
    <T> T get(@NonNull Prop<T> prop, @NonNull T defValue);

    <T> void set(@NonNull Prop<T> prop, @Nullable T value);

    <T> void clear(@NonNull Prop<T> prop);

    void clearAll();
}

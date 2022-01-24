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

import java.util.HashMap;
import java.util.Map;

/**
 * @since 3.0.0
 */
class RenderPropsImpl implements RenderProps {

    private final Map<Prop, Object> values = new HashMap<>(3);

    @Nullable
    @Override
    public <T> T get(@NonNull Prop<T> prop) {
        //noinspection unchecked
        return (T) values.get(prop);
    }

    @NonNull
    @Override
    public <T> T get(@NonNull Prop<T> prop, @NonNull T defValue) {
        Object value = values.get(prop);
        if (value != null) {
            //noinspection unchecked
            return (T) value;
        }
        return defValue;
    }

    @Override
    public <T> void set(@NonNull Prop<T> prop, @Nullable T value) {
        if (value == null) {
            values.remove(prop);
        } else {
            values.put(prop, value);
        }
    }

    @Override
    public <T> void clear(@NonNull Prop<T> prop) {
        values.remove(prop);
    }

    @Override
    public void clearAll() {
        values.clear();
    }
}

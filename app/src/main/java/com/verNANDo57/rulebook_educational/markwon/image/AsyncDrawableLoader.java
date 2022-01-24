/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.image;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class AsyncDrawableLoader {

    /**
     * @since 3.0.0
     */
    @NonNull
    public static AsyncDrawableLoader noOp() {
        return new AsyncDrawableLoaderNoOp();
    }

    /**
     * @since 4.0.0
     */
    public abstract void load(@NonNull AsyncDrawable drawable);

    /**
     * @since 4.0.0
     */
    public abstract void cancel(@NonNull AsyncDrawable drawable);

    @Nullable
    public abstract Drawable placeholder(@NonNull AsyncDrawable drawable);

}

/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.utils;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

/**
 * @deprecated Please use {@link DrawableUtils}
 */
@Deprecated
public abstract class DrawableUtils {

    public static void intrinsicBounds(@NonNull Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private DrawableUtils() {
    }
}

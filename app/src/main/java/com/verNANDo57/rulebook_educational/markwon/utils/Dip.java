/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.utils;

import android.content.Context;

import androidx.annotation.NonNull;

public class Dip {

    @NonNull
    public static Dip create(@NonNull Context context) {
        return new Dip(context.getResources().getDisplayMetrics().density);
    }

    @NonNull
    public static Dip create(float density) {
        return new Dip(density);
    }

    private final float density;

    @SuppressWarnings("WeakerAccess")
    public Dip(float density) {
        this.density = density;
    }

    public int toPx(int dp) {
        return (int) (dp * density + .5F);
    }
}

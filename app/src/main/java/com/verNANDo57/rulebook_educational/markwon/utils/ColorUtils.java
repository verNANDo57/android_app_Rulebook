/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.utils;

import android.graphics.Color;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;

public abstract class ColorUtils {

    @ColorInt
    public static int applyAlpha(
            @ColorInt int color,
            @IntRange(from = 0, to = 255) int alpha) {
        return (color & 0x00FFFFFF) | (alpha << 24);
    }

    // blend two colors w/ specified ratio, resulting color won't have alpha channel
    @ColorInt
    public static int blend(
            @ColorInt int foreground,
            @ColorInt int background,
            @FloatRange(from = 0.0F, to = 1.0F) float ratio) {
        return Color.rgb(
                (int) (((1F - ratio) * Color.red(foreground)) + (ratio * Color.red(background))),
                (int) (((1F - ratio) * Color.green(foreground)) + (ratio * Color.green(background))),
                (int) (((1F - ratio) * Color.blue(foreground)) + (ratio * Color.blue(background)))
        );
    }

    private ColorUtils() {
    }
}

/*
 * Author: Muddz
 * date: 2021/08/02
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2021/06/05
 */

package com.verNANDo57.rulebook_educational.styleabletoast;

import android.content.Context;
import android.util.TypedValue;

import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;

import java.util.Locale;

class StyleableToastUtils {
    static int toDp(Context context, int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    static boolean isRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == ViewCompat.LAYOUT_DIRECTION_RTL;
    }
}

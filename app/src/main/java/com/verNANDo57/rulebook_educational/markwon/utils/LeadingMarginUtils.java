/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.utils;

import android.text.Spanned;

public abstract class LeadingMarginUtils {

    public static boolean selfStart(int start, CharSequence text, Object span) {
        return text instanceof Spanned && ((Spanned) text).getSpanStart(span) == start;
    }

    public static boolean selfEnd(int end, CharSequence text, Object span) {
        return text instanceof Spanned && ((Spanned) text).getSpanEnd(span) == end;
    }

    private LeadingMarginUtils() {
    }
}

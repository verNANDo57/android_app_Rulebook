/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.utils;

import android.text.Spannable;
import android.text.SpannableString;

import androidx.annotation.NonNull;

/**
 * Utility SpannableFactory that re-uses Spannable instance between multiple
 * `TextView#setText` calls.
 *
 * @since 3.0.0
 */
public class NoCopySpannableFactory extends Spannable.Factory {

    @NonNull
    public static NoCopySpannableFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public Spannable newSpannable(CharSequence source) {
        return source instanceof Spannable
                ? (Spannable) source
                : new SpannableString(source);
    }

    static class Holder {
        private static final NoCopySpannableFactory INSTANCE = new NoCopySpannableFactory();
    }
}

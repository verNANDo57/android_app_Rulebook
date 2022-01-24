/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.syntax;

import android.text.SpannableStringBuilder;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.prism4j.Prism4j;

public interface Prism4jTheme {

    @ColorInt
    int background();

    @ColorInt
    int textColor();

    void apply(
            @NonNull String language,
            @NonNull Prism4j.Syntax syntax,
            @NonNull SpannableStringBuilder builder,
            int start,
            int end
    );
}

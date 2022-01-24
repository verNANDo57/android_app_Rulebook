/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.core.MarkwonTheme;

/**
 * @since 3.0.0 split inline and block spans
 */
public class CodeSpan extends MetricAffectingSpan {

    private final MarkwonTheme theme;

    public CodeSpan(@NonNull MarkwonTheme theme) {
        this.theme = theme;
    }

    @Override
    public void updateMeasureState(TextPaint p) {
        apply(p);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds);
        ds.bgColor = theme.getCodeBackgroundColor(ds);
    }

    private void apply(TextPaint p) {
        theme.applyCodeTextStyle(p);
    }
}

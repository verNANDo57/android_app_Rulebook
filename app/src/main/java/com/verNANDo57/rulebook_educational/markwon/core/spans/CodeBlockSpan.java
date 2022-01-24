/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.core.MarkwonTheme;

/**
 * @since 3.0.0 split inline and block spans
 */
public class CodeBlockSpan extends MetricAffectingSpan implements LeadingMarginSpan {

    private final MarkwonTheme theme;
    private final Rect rect = ObjectsPool.rect();
    private final Paint paint = ObjectsPool.paint();

    public CodeBlockSpan(@NonNull MarkwonTheme theme) {
        this.theme = theme;
    }

    @Override
    public void updateMeasureState(TextPaint p) {
        apply(p);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds);
    }

    private void apply(TextPaint p) {
        theme.applyCodeBlockTextStyle(p);
    }

    @Override
    public int getLeadingMargin(boolean first) {
        return theme.getCodeBlockMargin();
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(theme.getCodeBlockBackgroundColor(p));

        final int left;
        final int right;
        if (dir > 0) {
            left = x;
            right = c.getWidth();
        } else {
            left = x - c.getWidth();
            right = x;
        }

        rect.set(left, top, right, bottom);

        c.drawRect(rect, paint);
    }
}

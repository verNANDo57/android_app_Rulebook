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
import android.text.style.LeadingMarginSpan;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.core.MarkwonTheme;

public class BlockQuoteSpan implements LeadingMarginSpan {

    private final MarkwonTheme theme;
    private final Rect rect = ObjectsPool.rect();
    private final Paint paint = ObjectsPool.paint();

    public BlockQuoteSpan(@NonNull MarkwonTheme theme) {
        this.theme = theme;
    }

    @Override
    public int getLeadingMargin(boolean first) {
        return theme.getBlockMargin();
    }

    @Override
    public void drawLeadingMargin(
            Canvas c,
            Paint p,
            int x,
            int dir,
            int top,
            int baseline,
            int bottom,
            CharSequence text,
            int start,
            int end,
            boolean first,
            Layout layout) {

        final int width = theme.getBlockQuoteWidth();

        paint.set(p);

        theme.applyBlockQuoteStyle(paint);

        final int left;
        final int right;
        {
            final int l = x + (dir * width);
            final int r = l + (dir * width);
            left = Math.min(l, r);
            right = Math.max(l, r);
        }

        rect.set(left, top, right, bottom);

        c.drawRect(rect, paint);
    }
}

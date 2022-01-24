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

public class EmphasisSpan extends MetricAffectingSpan {

    @Override
    public void updateMeasureState(TextPaint p) {
        p.setTextSkewX(-0.25F);
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setTextSkewX(-0.25F);
    }
}

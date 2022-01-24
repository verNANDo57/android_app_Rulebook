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

public class StrongEmphasisSpan extends MetricAffectingSpan {

    @Override
    public void updateMeasureState(TextPaint p) {
        p.setFakeBoldText(true);
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setFakeBoldText(true);
    }
}

/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.core.factory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.verNANDo57.rulebook_educational.markwon.MarkwonConfiguration;
import com.verNANDo57.rulebook_educational.markwon.RenderProps;
import com.verNANDo57.rulebook_educational.markwon.SpanFactory;
import com.verNANDo57.rulebook_educational.markwon.core.spans.StrongEmphasisSpan;

public class StrongEmphasisSpanFactory implements SpanFactory {
    @Nullable
    @Override
    public Object getSpans(@NonNull MarkwonConfiguration configuration, @NonNull RenderProps props) {
        return new StrongEmphasisSpan();
    }
}

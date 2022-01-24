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
import com.verNANDo57.rulebook_educational.markwon.core.CoreProps;
import com.verNANDo57.rulebook_educational.markwon.core.spans.BulletListItemSpan;
import com.verNANDo57.rulebook_educational.markwon.core.spans.OrderedListItemSpan;

public class ListItemSpanFactory implements SpanFactory {

    @Nullable
    @Override
    public Object getSpans(@NonNull MarkwonConfiguration configuration, @NonNull RenderProps props) {

        // type of list item
        // bullet : level
        // ordered: number
        final Object spans;

        if (CoreProps.ListItemType.BULLET == CoreProps.LIST_ITEM_TYPE.require(props)) {
            spans = new BulletListItemSpan(
                    configuration.theme(),
                    CoreProps.BULLET_LIST_ITEM_LEVEL.require(props)
            );
        } else {

            // todo| in order to provide real RTL experience there must be a way to provide this string
            final String number = String.valueOf(CoreProps.ORDERED_LIST_ITEM_NUMBER.require(props))
                    + "." + '\u00a0';

            spans = new OrderedListItemSpan(
                    configuration.theme(),
                    number
            );
        }

        return spans;
    }
}

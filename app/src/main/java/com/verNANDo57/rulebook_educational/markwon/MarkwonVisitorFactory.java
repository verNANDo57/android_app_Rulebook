/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon;

import androidx.annotation.NonNull;

/**
 * @since 4.1.1
 */
abstract class MarkwonVisitorFactory {

    @NonNull
    abstract MarkwonVisitor create();

    @NonNull
    static MarkwonVisitorFactory create(
            @NonNull final MarkwonVisitorImpl.Builder builder,
            @NonNull final MarkwonConfiguration configuration) {
        return new MarkwonVisitorFactory() {
            @NonNull
            @Override
            MarkwonVisitor create() {
                return builder.build(configuration, new RenderPropsImpl());
            }
        };
    }
}

/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.node.Node;

/**
 * @since 4.3.0
 */
public class BlockHandlerDef implements MarkwonVisitor.BlockHandler {
    @Override
    public void blockStart(@NonNull MarkwonVisitor visitor, @NonNull Node node) {
        visitor.ensureNewLine();
    }

    @Override
    public void blockEnd(@NonNull MarkwonVisitor visitor, @NonNull Node node) {
        if (visitor.hasNext(node)) {
            visitor.ensureNewLine();
            visitor.forceNewLine();
        }
    }
}

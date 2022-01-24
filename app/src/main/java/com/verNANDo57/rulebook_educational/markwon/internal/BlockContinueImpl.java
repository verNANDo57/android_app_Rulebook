/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal;

import com.verNANDo57.rulebook_educational.markwon.parser.block.BlockContinue;

public class BlockContinueImpl extends BlockContinue {

    private final int newIndex;
    private final int newColumn;
    private final boolean finalize;

    public BlockContinueImpl(int newIndex, int newColumn, boolean finalize) {
        this.newIndex = newIndex;
        this.newColumn = newColumn;
        this.finalize = finalize;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public int getNewColumn() {
        return newColumn;
    }

    public boolean isFinalize() {
        return finalize;
    }

}

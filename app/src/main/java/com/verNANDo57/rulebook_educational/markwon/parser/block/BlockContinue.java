/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.parser.block;

import com.verNANDo57.rulebook_educational.markwon.internal.BlockContinueImpl;

/**
 * Result object for continuing parsing of a block, see static methods for constructors.
 */
public class BlockContinue {

    protected BlockContinue() {
    }

    public static BlockContinue none() {
        return null;
    }

    public static BlockContinue atIndex(int newIndex) {
        return new BlockContinueImpl(newIndex, -1, false);
    }

    public static BlockContinue atColumn(int newColumn) {
        return new BlockContinueImpl(-1, newColumn, false);
    }

    public static BlockContinue finished() {
        return new BlockContinueImpl(-1, -1, true);
    }

}

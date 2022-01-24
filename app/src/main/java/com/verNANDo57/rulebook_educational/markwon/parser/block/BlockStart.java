/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.parser.block;

import com.verNANDo57.rulebook_educational.markwon.internal.BlockStartImpl;

/**
 * Result object for starting parsing of a block, see static methods for constructors.
 */
public abstract class BlockStart {

    protected BlockStart() {
    }

    public static BlockStart none() {
        return null;
    }

    public static BlockStart of(BlockParser... blockParsers) {
        return new BlockStartImpl(blockParsers);
    }

    public abstract BlockStart atIndex(int newIndex);

    public abstract BlockStart atColumn(int newColumn);

    public abstract BlockStart replaceActiveBlockParser();

}

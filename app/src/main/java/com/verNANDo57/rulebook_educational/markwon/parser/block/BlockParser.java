/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.parser.block;

import com.verNANDo57.rulebook_educational.markwon.node.Block;
import com.verNANDo57.rulebook_educational.markwon.parser.InlineParser;

/**
 * Parser for a specific block node.
 * <p>
 * Implementations should subclass {@link AbstractBlockParser} instead of implementing this directly.
 */
public interface BlockParser {

    /**
     * Return true if the block that is parsed is a container (contains other blocks), or false if it's a leaf.
     */
    boolean isContainer();

    /**
     * Return true if the block can have lazy continuation lines.
     * <p>
     * Lazy continuation lines are lines that were rejected by this {@link #tryContinue(ParserState)} but didn't match
     * any other block parsers either.
     * <p>
     * If true is returned here, those lines will get added via {@link #addLine(CharSequence)}. For false, the block is
     * closed instead.
     */
    boolean canHaveLazyContinuationLines();

    boolean canContain(Block childBlock);

    Block getBlock();

    BlockContinue tryContinue(ParserState parserState);

    void addLine(CharSequence line);

    void closeBlock();

    void parseInlines(InlineParser inlineParser);

}

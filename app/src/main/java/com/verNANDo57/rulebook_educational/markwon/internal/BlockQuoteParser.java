/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal;

import com.verNANDo57.rulebook_educational.markwon.internal.util.Parsing;
import com.verNANDo57.rulebook_educational.markwon.node.Block;
import com.verNANDo57.rulebook_educational.markwon.node.BlockQuote;
import com.verNANDo57.rulebook_educational.markwon.parser.block.AbstractBlockParser;
import com.verNANDo57.rulebook_educational.markwon.parser.block.AbstractBlockParserFactory;
import com.verNANDo57.rulebook_educational.markwon.parser.block.BlockContinue;
import com.verNANDo57.rulebook_educational.markwon.parser.block.BlockStart;
import com.verNANDo57.rulebook_educational.markwon.parser.block.MatchedBlockParser;
import com.verNANDo57.rulebook_educational.markwon.parser.block.ParserState;

public class BlockQuoteParser extends AbstractBlockParser {

    private final BlockQuote block = new BlockQuote();

    @Override
    public boolean isContainer() {
        return true;
    }

    @Override
    public boolean canContain(Block block) {
        return true;
    }

    @Override
    public BlockQuote getBlock() {
        return block;
    }

    @Override
    public BlockContinue tryContinue(ParserState state) {
        int nextNonSpace = state.getNextNonSpaceIndex();
        if (isMarker(state, nextNonSpace)) {
            int newColumn = state.getColumn() + state.getIndent() + 1;
            // optional following space or tab
            if (Parsing.isSpaceOrTab(state.getLine(), nextNonSpace + 1)) {
                newColumn++;
            }
            return BlockContinue.atColumn(newColumn);
        } else {
            return BlockContinue.none();
        }
    }

    private static boolean isMarker(ParserState state, int index) {
        CharSequence line = state.getLine();
        return state.getIndent() < Parsing.CODE_BLOCK_INDENT && index < line.length() && line.charAt(index) == '>';
    }

    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            int nextNonSpace = state.getNextNonSpaceIndex();
            if (isMarker(state, nextNonSpace)) {
                int newColumn = state.getColumn() + state.getIndent() + 1;
                // optional following space or tab
                if (Parsing.isSpaceOrTab(state.getLine(), nextNonSpace + 1)) {
                    newColumn++;
                }
                return BlockStart.of(new BlockQuoteParser()).atColumn(newColumn);
            } else {
                return BlockStart.none();
            }
        }
    }
}

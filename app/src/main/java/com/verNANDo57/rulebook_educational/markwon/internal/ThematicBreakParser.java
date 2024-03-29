/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal;

import com.verNANDo57.rulebook_educational.markwon.node.Block;
import com.verNANDo57.rulebook_educational.markwon.node.ThematicBreak;
import com.verNANDo57.rulebook_educational.markwon.parser.block.AbstractBlockParser;
import com.verNANDo57.rulebook_educational.markwon.parser.block.AbstractBlockParserFactory;
import com.verNANDo57.rulebook_educational.markwon.parser.block.BlockContinue;
import com.verNANDo57.rulebook_educational.markwon.parser.block.BlockStart;
import com.verNANDo57.rulebook_educational.markwon.parser.block.MatchedBlockParser;
import com.verNANDo57.rulebook_educational.markwon.parser.block.ParserState;

public class ThematicBreakParser extends AbstractBlockParser {

    private final ThematicBreak block = new ThematicBreak();

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public BlockContinue tryContinue(ParserState state) {
        // a horizontal rule can never container > 1 line, so fail to match
        return BlockContinue.none();
    }

    public static class Factory extends AbstractBlockParserFactory {

        @Override
        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            if (state.getIndent() >= 4) {
                return BlockStart.none();
            }
            int nextNonSpace = state.getNextNonSpaceIndex();
            CharSequence line = state.getLine();
            if (isThematicBreak(line, nextNonSpace)) {
                return BlockStart.of(new ThematicBreakParser()).atIndex(line.length());
            } else {
                return BlockStart.none();
            }
        }
    }

    // spec: A line consisting of 0-3 spaces of indentation, followed by a sequence of three or more matching -, _, or *
    // characters, each followed optionally by any number of spaces, forms a thematic break.
    private static boolean isThematicBreak(CharSequence line, int index) {
        int dashes = 0;
        int underscores = 0;
        int asterisks = 0;
        int length = line.length();
        for (int i = index; i < length; i++) {
            switch (line.charAt(i)) {
                case '-':
                    dashes++;
                    break;
                case '_':
                    underscores++;
                    break;
                case '*':
                    asterisks++;
                    break;
                case ' ':
                case '\t':
                    // Allowed, even between markers
                    break;
                default:
                    return false;
            }
        }

        return ((dashes >= 3 && underscores == 0 && asterisks == 0) ||
                (underscores >= 3 && dashes == 0 && asterisks == 0) ||
                (asterisks >= 3 && dashes == 0 && underscores == 0));
    }
}

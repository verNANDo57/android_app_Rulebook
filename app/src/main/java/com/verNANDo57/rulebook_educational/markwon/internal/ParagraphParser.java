/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal;

import com.verNANDo57.rulebook_educational.markwon.node.Block;
import com.verNANDo57.rulebook_educational.markwon.node.LinkReferenceDefinition;
import com.verNANDo57.rulebook_educational.markwon.node.Paragraph;
import com.verNANDo57.rulebook_educational.markwon.parser.InlineParser;
import com.verNANDo57.rulebook_educational.markwon.parser.block.AbstractBlockParser;
import com.verNANDo57.rulebook_educational.markwon.parser.block.BlockContinue;
import com.verNANDo57.rulebook_educational.markwon.parser.block.ParserState;

import java.util.List;

public class ParagraphParser extends AbstractBlockParser {

    private final Paragraph block = new Paragraph();
    private final LinkReferenceDefinitionParser linkReferenceDefinitionParser = new LinkReferenceDefinitionParser();

    @Override
    public boolean canHaveLazyContinuationLines() {
        return true;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public BlockContinue tryContinue(ParserState state) {
        if (!state.isBlank()) {
            return BlockContinue.atIndex(state.getIndex());
        } else {
            return BlockContinue.none();
        }
    }

    @Override
    public void addLine(CharSequence line) {
        linkReferenceDefinitionParser.parse(line);
    }

    @Override
    public void closeBlock() {
        if (linkReferenceDefinitionParser.getParagraphContent().length() == 0) {
            block.unlink();
        }
    }

    @Override
    public void parseInlines(InlineParser inlineParser) {
        CharSequence content = linkReferenceDefinitionParser.getParagraphContent();
        if (content.length() > 0) {
            inlineParser.parse(content.toString(), block);
        }
    }

    public CharSequence getContentString() {
        return linkReferenceDefinitionParser.getParagraphContent();
    }

    public List<LinkReferenceDefinition> getDefinitions() {
        return linkReferenceDefinitionParser.getDefinitions();
    }
}

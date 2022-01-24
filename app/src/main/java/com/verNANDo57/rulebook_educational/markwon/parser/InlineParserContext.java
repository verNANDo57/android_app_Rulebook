/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.parser;

import com.verNANDo57.rulebook_educational.markwon.node.LinkReferenceDefinition;
import com.verNANDo57.rulebook_educational.markwon.parser.delimiter.DelimiterProcessor;

import java.util.List;

/**
 * Context for inline parsing.
 */
public interface InlineParserContext {

    /**
     * @return custom delimiter processors that have been configured with {@link Parser.Builder#customDelimiterProcessor(DelimiterProcessor)}
     */
    List<DelimiterProcessor> getCustomDelimiterProcessors();

    /**
     * Look up a {@link LinkReferenceDefinition} for a given label.
     *
     * @param label the link label to look up
     * @return the definition if one exists, {@code null} otherwise
     */
    LinkReferenceDefinition getLinkReferenceDefinition(String label);
}

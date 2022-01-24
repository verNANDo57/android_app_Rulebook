/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.parser.block;

/**
 * Open block parser that was last matched during the continue phase. This is different from the currently active
 * block parser, as an unmatched block is only closed when a new block is started.
 * <p><em>This interface is not intended to be implemented by clients.</em></p>
 */
public interface MatchedBlockParser {

    BlockParser getMatchedBlockParser();

    /**
     * Returns the current content of the paragraph if the matched block is a paragraph. The content can be multiple
     * lines separated by {@code '\n'}.
     *
     * @return paragraph content or {@code null}
     */
    CharSequence getParagraphContent();

}

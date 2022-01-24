/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal.inline;

import com.verNANDo57.rulebook_educational.markwon.node.Emphasis;
import com.verNANDo57.rulebook_educational.markwon.node.Node;
import com.verNANDo57.rulebook_educational.markwon.node.StrongEmphasis;
import com.verNANDo57.rulebook_educational.markwon.node.Text;
import com.verNANDo57.rulebook_educational.markwon.parser.delimiter.DelimiterProcessor;
import com.verNANDo57.rulebook_educational.markwon.parser.delimiter.DelimiterRun;

public abstract class EmphasisDelimiterProcessor implements DelimiterProcessor {

    private final char delimiterChar;

    protected EmphasisDelimiterProcessor(char delimiterChar) {
        this.delimiterChar = delimiterChar;
    }

    @Override
    public char getOpeningCharacter() {
        return delimiterChar;
    }

    @Override
    public char getClosingCharacter() {
        return delimiterChar;
    }

    @Override
    public int getMinLength() {
        return 1;
    }

    @Override
    public int getDelimiterUse(DelimiterRun opener, DelimiterRun closer) {
        // "multiple of 3" rule for internal delimiter runs
        if ((opener.canClose() || closer.canOpen()) &&
                closer.originalLength() % 3 != 0 &&
                (opener.originalLength() + closer.originalLength()) % 3 == 0) {
            return 0;
        }
        // calculate actual number of delimiters used from this closer
        if (opener.length() >= 2 && closer.length() >= 2) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public void process(Text opener, Text closer, int delimiterUse) {
        String singleDelimiter = String.valueOf(getOpeningCharacter());
        Node emphasis = delimiterUse == 1
                ? new Emphasis(singleDelimiter)
                : new StrongEmphasis(singleDelimiter + singleDelimiter);

        Node tmp = opener.getNext();
        while (tmp != null && tmp != closer) {
            Node next = tmp.getNext();
            emphasis.appendChild(tmp);
            tmp = next;
        }

        opener.insertAfter(emphasis);
    }
}

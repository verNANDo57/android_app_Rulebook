/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal;

class BlockContent {

    private final StringBuilder sb;

    private int lineCount = 0;

    public BlockContent() {
        sb = new StringBuilder();
    }

    public BlockContent(String content) {
        sb = new StringBuilder(content);
    }

    public void add(CharSequence line) {
        if (lineCount != 0) {
            sb.append('\n');
        }
        sb.append(line);
        lineCount++;
    }

    public String getString() {
        return sb.toString();
    }

}

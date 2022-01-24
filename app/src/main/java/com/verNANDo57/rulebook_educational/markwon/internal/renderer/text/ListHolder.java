/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal.renderer.text;

public abstract class ListHolder {
    private static final String INDENT_DEFAULT = "   ";
    private static final String INDENT_EMPTY = "";

    private final ListHolder parent;
    private final String indent;

    ListHolder(ListHolder parent) {
        this.parent = parent;

        if (parent != null) {
            indent = parent.indent + INDENT_DEFAULT;
        } else {
            indent = INDENT_EMPTY;
        }
    }

    public ListHolder getParent() {
        return parent;
    }

    public String getIndent() {
        return indent;
    }
}

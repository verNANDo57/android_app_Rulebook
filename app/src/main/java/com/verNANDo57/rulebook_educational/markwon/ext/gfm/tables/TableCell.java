/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables;

import com.verNANDo57.rulebook_educational.markwon.node.CustomNode;

/**
 * Table cell of a {@link TableRow} containing inline nodes.
 */
public class TableCell extends CustomNode {

    private boolean header;
    private Alignment alignment;

    /**
     * @return whether the cell is a header or not
     */
    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    /**
     * @return the cell alignment
     */
    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    /**
     * How the cell is aligned horizontally.
     */
    public enum Alignment {
        LEFT, CENTER, RIGHT
    }

}

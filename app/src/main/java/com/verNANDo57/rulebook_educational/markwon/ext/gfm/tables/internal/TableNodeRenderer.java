/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.internal;

import com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.TableBlock;
import com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.TableBody;
import com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.TableCell;
import com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.TableHead;
import com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.TableRow;
import com.verNANDo57.rulebook_educational.markwon.node.Node;
import com.verNANDo57.rulebook_educational.markwon.renderer.NodeRenderer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

abstract class TableNodeRenderer implements NodeRenderer {

    @Override
    public Set<Class<? extends Node>> getNodeTypes() {
        return new HashSet<>(Arrays.asList(
                TableBlock.class,
                TableHead.class,
                TableBody.class,
                TableRow.class,
                TableCell.class
        ));
    }

    @Override
    public void render(Node node) {
        if (node instanceof TableBlock) {
            renderBlock((TableBlock) node);
        } else if (node instanceof TableHead) {
            renderHead((TableHead) node);
        } else if (node instanceof TableBody) {
            renderBody((TableBody) node);
        } else if (node instanceof TableRow) {
            renderRow((TableRow) node);
        } else if (node instanceof TableCell) {
            renderCell((TableCell) node);
        }
    }

    protected abstract void renderBlock(TableBlock node);

    protected abstract void renderHead(TableHead node);

    protected abstract void renderBody(TableBody node);

    protected abstract void renderRow(TableRow node);

    protected abstract void renderCell(TableCell node);
}

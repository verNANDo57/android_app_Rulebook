/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal.renderer.text;

import com.verNANDo57.rulebook_educational.markwon.node.BulletList;

public class BulletListHolder extends ListHolder {
    private final char marker;

    public BulletListHolder(ListHolder parent, BulletList list) {
        super(parent);
        marker = list.getBulletMarker();
    }

    public char getMarker() {
        return marker;
    }
}

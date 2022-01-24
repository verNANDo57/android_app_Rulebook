/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal.renderer.text;

import com.verNANDo57.rulebook_educational.markwon.node.OrderedList;

public class OrderedListHolder extends ListHolder {
    private final char delimiter;
    private int counter;

    public OrderedListHolder(ListHolder parent, OrderedList list) {
        super(parent);
        delimiter = list.getDelimiter();
        counter = list.getStartNumber();
    }

    public char getDelimiter() {
        return delimiter;
    }

    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter++;
    }
}

/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.utils;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.node.Node;

/**
 * @since 4.6.0
 */
public abstract class ParserUtils {

    public static void moveChildren(@NonNull Node to, @NonNull Node from) {
        Node next = from.getNext();
        Node temp;
        while (next != null) {
            // appendChild would unlink passed node (thus making next info un-available)
            temp = next.getNext();
            to.appendChild(next);
            next = temp;
        }
    }

    private ParserUtils() {
    }
}

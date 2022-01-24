/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.node.LinkReferenceDefinition;
import com.verNANDo57.rulebook_educational.markwon.node.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @since 3.0.0
 */
public abstract class MarkwonReducer {

    /**
     * @return direct children of supplied Node. In the most usual case
     * will return all BlockNodes of a Document
     */
    @NonNull
    public static MarkwonReducer directChildren() {
        return new DirectChildren();
    }

    @NonNull
    public abstract List<Node> reduce(@NonNull Node node);


    static class DirectChildren extends MarkwonReducer {

        @NonNull
        @Override
        public List<Node> reduce(@NonNull Node root) {

            final List<Node> list;

            // we will extract all blocks that are direct children of Document
            Node node = root.getFirstChild();

            // please note, that if there are no children -> we will return a list with
            // single element (which was supplied)
            if (node == null) {
                list = Collections.singletonList(root);
            } else {

                list = new ArrayList<>();

                Node temp;

                while (node != null) {
                    // @since 4.5.0 do not include LinkReferenceDefinition node (would result
                    //  in empty textView if rendered in recycler-view)
                    if (!(node instanceof LinkReferenceDefinition)) {
                        list.add(node);
                    }
                    temp = node.getNext();
                    node.unlink();
                    node = temp;
                }
            }

            return list;
        }
    }
}

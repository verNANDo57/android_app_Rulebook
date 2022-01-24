/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.renderer;

import com.verNANDo57.rulebook_educational.markwon.node.Node;

import java.util.Set;

/**
 * A renderer for a set of node types.
 */
public interface NodeRenderer {

    /**
     * @return the types of nodes that this renderer handles
     */
    Set<Class<? extends Node>> getNodeTypes();

    /**
     * Render the specified node.
     *
     * @param node the node to render, will be an instance of one of {@link #getNodeTypes()}
     */
    void render(Node node);
}

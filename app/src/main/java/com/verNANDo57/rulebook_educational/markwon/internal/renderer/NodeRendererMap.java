/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.internal.renderer;

import com.verNANDo57.rulebook_educational.markwon.node.Node;
import com.verNANDo57.rulebook_educational.markwon.renderer.NodeRenderer;

import java.util.HashMap;
import java.util.Map;

public class NodeRendererMap {

    private final Map<Class<? extends Node>, NodeRenderer> renderers = new HashMap<>(32);

    public void add(NodeRenderer nodeRenderer) {
        for (Class<? extends Node> nodeType : nodeRenderer.getNodeTypes()) {
            // Overwrite existing renderer
            renderers.put(nodeType, nodeRenderer);
        }
    }

    public void render(Node node) {
        NodeRenderer nodeRenderer = renderers.get(node.getClass());
        if (nodeRenderer != null) {
            nodeRenderer.render(node);
        }
    }
}

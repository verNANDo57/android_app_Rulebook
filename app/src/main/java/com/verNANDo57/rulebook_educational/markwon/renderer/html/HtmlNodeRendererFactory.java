/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.renderer.html;

import com.verNANDo57.rulebook_educational.markwon.renderer.NodeRenderer;

/**
 * Factory for instantiating new node renderers when rendering is done.
 */
public interface HtmlNodeRendererFactory {

    /**
     * Create a new node renderer for the specified rendering context.
     *
     * @param context the context for rendering (normally passed on to the node renderer)
     * @return a node renderer
     */
    NodeRenderer create(HtmlNodeRendererContext context);
}

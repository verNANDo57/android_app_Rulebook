/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.renderer.html;

/**
 * Factory for instantiating new attribute providers when rendering is done.
 */
public interface AttributeProviderFactory {

    /**
     * Create a new attribute provider.
     *
     * @param context for this attribute provider
     * @return an AttributeProvider
     */
    AttributeProvider create(AttributeProviderContext context);
}

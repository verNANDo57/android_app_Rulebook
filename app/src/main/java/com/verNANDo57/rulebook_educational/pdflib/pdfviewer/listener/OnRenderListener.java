/*
 * Author: barteksc
 * date: 2019/08/18
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.listener;

public interface OnRenderListener {

    /**
     * Called only once, when document is rendered
     * @param nbPages number of pages
     */
    void onInitiallyRendered(int nbPages);
}

/*
 * Author: barteksc
 * date: 2019/08/18
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.listener;

/**
 * Implements this interface to receive events from PDFView
 * when the view has been scrolled
 */
public interface OnScrollListener {

    /**
     * Called on every move while scrolling
     *
     * @param x for horizontal offset
     * @param y for vertical offset
     */
    void onScroll(float x, float y);
}

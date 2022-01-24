/*
 * Author: barteksc
 * date: 2019/08/18
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.listener;

import android.graphics.Canvas;

/**
 * This interface allows an extern class to draw
 * something on the PDFView canvas, above all images.
 */
public interface OnDrawListener {

    /**
     * This method is called when the PDFView is
     * drawing its view.
     * <p>
     * The page is starting at (0,0)
     *
     * @param canvas        The canvas on which to draw things.
     * @param pageWidth     The width of the current page.
     * @param pageHeight    The height of the current page.
     * @param displayedPage The current page index
     */
    void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage);
}

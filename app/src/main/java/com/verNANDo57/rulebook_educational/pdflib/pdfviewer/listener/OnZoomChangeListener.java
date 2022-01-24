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
 * when the view has been pinched
 */
public interface OnZoomChangeListener {

    /**
     * Called on every move while pinching
     *
     * @param zoom is the new zoom
     */
    void onZoomChanged(float zoom);
}

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

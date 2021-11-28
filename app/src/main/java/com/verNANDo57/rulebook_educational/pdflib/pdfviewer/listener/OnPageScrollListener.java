package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.listener;

/**
 * Implements this interface to receive events from PDFView
 * when a page has been scrolled
 */
public interface OnPageScrollListener {

    /**
     * Called on every move while scrolling
     *
     * @param page current page index
     * @param positionOffset see {@link com.verNANDo57.rulebook_educational.pdflib.pdfviewer.PDFView#getPositionOffset()}
     */
    void onPageScrolled(int page, float positionOffset);
}

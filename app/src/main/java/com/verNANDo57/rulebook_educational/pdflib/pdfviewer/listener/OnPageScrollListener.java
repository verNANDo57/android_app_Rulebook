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

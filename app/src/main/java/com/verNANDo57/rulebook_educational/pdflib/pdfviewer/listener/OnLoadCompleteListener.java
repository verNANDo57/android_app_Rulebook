/*
 * Author: barteksc
 * date: 2019/08/18
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.listener;

/**
 * Implement this interface to receive events from PDFView
 * when loading is complete.
 */
public interface OnLoadCompleteListener {

    /**
     * Called when the PDF is loaded
     * @param nbPages the number of pages in this PDF file
     */
    void loadComplete(int nbPages);
}

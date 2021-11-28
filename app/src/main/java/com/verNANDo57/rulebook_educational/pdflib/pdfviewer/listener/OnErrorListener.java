package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.listener;

public interface OnErrorListener {

    /**
     * Called if error occurred while opening PDF
     * @param t Throwable with error
     */
    void onError(Throwable t);
}

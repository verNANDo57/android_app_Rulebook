/*
 * Author: barteksc
 * date: 2019/08/18
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.listener;

import android.view.MotionEvent;

/**
 * Implement this interface to receive events from PDFView
 * when view has been touched
 */
public interface OnTapListener {

    /**
     * Called when the user has a tap gesture, before processing scroll handle toggling
     *
     * @param e MotionEvent that registered as a confirmed single tap
     * @return true if the single tap was handled, false to toggle scroll handle
     */
    boolean onTap(MotionEvent e);
}

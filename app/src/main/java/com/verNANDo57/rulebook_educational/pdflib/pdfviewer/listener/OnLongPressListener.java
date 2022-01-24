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
 * when view has been long pressed
 */
public interface OnLongPressListener {

    /**
     * Called when the user has a long tap gesture, before processing scroll handle toggling
     *
     * @param e MotionEvent that registered as a confirmed long press
     */
    void onLongPress(MotionEvent e);
}

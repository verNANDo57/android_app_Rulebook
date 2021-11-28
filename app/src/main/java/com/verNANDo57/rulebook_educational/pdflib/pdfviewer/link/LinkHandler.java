package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.link;

import com.verNANDo57.rulebook_educational.pdflib.pdfviewer.model.LinkTapEvent;

public interface LinkHandler {

    /**
     * Called when link was tapped by user
     *
     * @param event current event
     */
    void handleLinkEvent(LinkTapEvent event);
}

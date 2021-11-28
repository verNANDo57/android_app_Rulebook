package com.verNANDo57.rulebook_educational.pdflib.pdfviewer;

import com.verNANDo57.rulebook_educational.pdflib.pdfviewer.model.PagePart;

import java.util.Comparator;

public class PagePartComparator implements Comparator<PagePart> {
    @Override
    public int compare(PagePart part1, PagePart part2) {
        if (part1.getCacheOrder() == part2.getCacheOrder()) {
            return 0;
        }
        return part1.getCacheOrder() > part2.getCacheOrder() ? 1 : -1;
    }
}

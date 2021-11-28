package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.source;

import android.content.Context;

import com.verNANDo57.rulebook_educational.pdflib.pdfium.PdfDocument;
import com.verNANDo57.rulebook_educational.pdflib.pdfium.PdfiumCore;

import java.io.IOException;

public interface DocumentSource {
    PdfDocument createDocument(Context context, PdfiumCore core, String password) throws IOException;
}

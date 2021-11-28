package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.source;

import android.content.Context;

import com.verNANDo57.rulebook_educational.pdflib.pdfium.PdfDocument;
import com.verNANDo57.rulebook_educational.pdflib.pdfium.PdfiumCore;
import com.verNANDo57.rulebook_educational.pdflib.pdfviewer.util.Util;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamSource implements DocumentSource {

    private final InputStream inputStream;

    public InputStreamSource(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public PdfDocument createDocument(Context context, PdfiumCore core, String password) throws IOException {
        return core.newDocument(Util.toByteArray(inputStream), password);
    }
}

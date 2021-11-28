package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.source;

import android.content.Context;

import com.verNANDo57.rulebook_educational.pdflib.pdfium.PdfDocument;
import com.verNANDo57.rulebook_educational.pdflib.pdfium.PdfiumCore;

import java.io.IOException;

public class ByteArraySource implements DocumentSource {

    private final byte[] data;

    public ByteArraySource(byte[] data) {
        this.data = data;
    }

    @Override
    public PdfDocument createDocument(Context context, PdfiumCore core, String password) throws IOException {
        return core.newDocument(data, password);
    }
}

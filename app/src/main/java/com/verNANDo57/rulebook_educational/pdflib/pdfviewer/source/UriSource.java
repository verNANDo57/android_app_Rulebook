/*
 * Author: barteksc
 * date: 2019/08/18
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.source;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

import com.verNANDo57.rulebook_educational.pdflib.pdfium.PdfDocument;
import com.verNANDo57.rulebook_educational.pdflib.pdfium.PdfiumCore;

import java.io.IOException;

public class UriSource implements DocumentSource {

    private final Uri uri;

    public UriSource(Uri uri) {
        this.uri = uri;
    }

    @Override
    public PdfDocument createDocument(Context context, PdfiumCore core, String password) throws IOException {
        ParcelFileDescriptor pfd = context.getContentResolver().openFileDescriptor(uri, "r");
        return core.newDocument(pfd, password);
    }
}

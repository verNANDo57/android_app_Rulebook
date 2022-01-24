/*
 * Author: barteksc
 * date: 2019/08/18
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.pdflib.pdfviewer.exception;

@Deprecated
public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String detailMessage) {
        super(detailMessage);
    }

    public FileNotFoundException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}

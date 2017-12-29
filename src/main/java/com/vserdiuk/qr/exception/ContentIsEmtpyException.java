package com.vserdiuk.qr.exception;

/**
 * Created by vserdiuk on 12/21/17.
 */

public class ContentIsEmtpyException extends RuntimeException {

    public ContentIsEmtpyException() {
        super("Content is empty");
    }

} 
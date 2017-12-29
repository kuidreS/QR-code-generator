package com.vserdiuk.qr.bl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.vserdiuk.qr.exception.ContentIsEmtpyException;
import com.vserdiuk.qr.exception.QrEncodingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vserdiuk on 12/21/17.
 */

public class BlobGenerator implements Generator {

    final static Logger logger = Logger.getLogger(BlobGenerator.class);

    @Autowired
    private QRCodeWriter qrCodeWriter;

    @Override
    public boolean[][] generate(int size, String content) {
        boolean[][] blob;
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, size, size);
            blob = new boolean[size][size];
            for (int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    blob[i][j] = bitMatrix.get(i, j);
                }
            }
            logger.debug("Binary large object has been generated");
        } catch (WriterException e) {
            throw new QrEncodingException(e.getMessage());
        }

        if(blob == null) {
            throw new ContentIsEmtpyException();
        }
        return blob;
    }

}
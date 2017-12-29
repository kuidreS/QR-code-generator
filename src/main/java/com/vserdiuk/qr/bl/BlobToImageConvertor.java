package com.vserdiuk.qr.bl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by vserdiuk on 12/21/17.
 */

public class BlobToImageConvertor implements Convertor {

    final static Logger logger = Logger.getLogger(BlobToImageConvertor.class);

    @Override
    public BufferedImage convert(boolean[][] blob, int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, size, size);

        graphics.setColor(Color.BLACK);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (blob[i][j]) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        logger.debug("Blob has been converted to an image");
        return image;
    }

}
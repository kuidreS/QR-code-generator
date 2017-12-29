package com.vserdiuk.qr.bl;

import java.awt.image.BufferedImage;

/**
 * Created by vserdiuk on 12/21/17.
 */

public interface Convertor {

    BufferedImage convert(boolean[][] blob, int size);

}

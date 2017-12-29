package com.vserdiuk.qr.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by vserdiuk on 12/22/17.
 */

public class AppUtil {

    final static Logger logger = Logger.getLogger(AppUtil.class);

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            logger.error(e);
        }
    }

} 
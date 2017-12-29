package com.vserdiuk.qr.bl;

import org.apache.log4j.Logger;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * Created by vserdiuk on 12/22/17.
 */

public class ContentCryptographer implements Cryptographer {

    final static Logger logger = Logger.getLogger(ContentCryptographer.class);

    private static final String KEY = "DIMuShuJtxRdPZr3";
    public static final String INIT_VEKTOR = "5U0MTXv1BLcDVMga";

    @Override
    public String encrypt(String basicString) {
        String encryptedString = "";
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VEKTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(basicString.getBytes());

            encryptedString = Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            logger.error(e);
        }
        return encryptedString;
    }

    @Override
    public String decrypt(String encryptedString) {
        String decryptedString = "";
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VEKTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encryptedString));

            decryptedString = new String(original);
        } catch (Exception e) {
            logger.error(e);
        }
        return decryptedString;
    }

}
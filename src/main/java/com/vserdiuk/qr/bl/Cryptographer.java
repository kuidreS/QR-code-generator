package com.vserdiuk.qr.bl;

/**
 * Created by vserdiuk on 12/22/17.
 */

public interface Cryptographer {

    String encrypt(String basicString);

    String decrypt(String encryptedString);

}

package com.vserdiuk.qr.config;

import com.google.zxing.qrcode.QRCodeWriter;
import com.vserdiuk.qr.bl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vserdiuk on 12/21/17.
 */

@Configuration
public class AppConfig {

    @Bean
    public QRCodeWriter qrCodeWriter() {
        return new QRCodeWriter();
    }

    @Bean
    public Generator generator() {
        return new BlobGenerator();
    }

    @Bean
    public Convertor convertor() {
        return new BlobToImageConvertor();
    }

    @Bean
    public Cryptographer cryptographer() {
        return new ContentCryptographer();
    }

} 
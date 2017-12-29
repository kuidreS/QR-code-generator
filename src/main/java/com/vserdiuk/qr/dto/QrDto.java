package com.vserdiuk.qr.dto;

import lombok.Data;

/**
 * Created by vserdiuk on 12/21/17.
 */

@Data
public class QrDto {
    private String content;
    private int size;
    private String fileType;
} 
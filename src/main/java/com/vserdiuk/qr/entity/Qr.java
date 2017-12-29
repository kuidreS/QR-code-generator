package com.vserdiuk.qr.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by vserdiuk on 12/21/17.
 */

@Data
@Entity
@Table(name = "qr")
public class Qr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "content")
    private String content;

    @Lob
    @Column(name = "qr_image")
    private byte[] qr;

} 
package com.vserdiuk.qr.controller;

import com.vserdiuk.qr.bl.Convertor;
import com.vserdiuk.qr.bl.Cryptographer;
import com.vserdiuk.qr.bl.Generator;
import com.vserdiuk.qr.dto.QrDto;
import com.vserdiuk.qr.entity.Qr;
import com.vserdiuk.qr.repository.QrRepository;
import com.vserdiuk.qr.util.AppUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by vserdiuk on 12/21/17.
 */

@RestController
@RequestMapping("/qr")
public class QrController {

    final static Logger logger = Logger.getLogger(AppUtil.class);

    @Autowired
    private QrRepository repository;

    @Autowired
    private Generator generator;

    @Autowired
    private Convertor convertor;

    @Autowired
    private Cryptographer cryptographer;

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public void setContent(@RequestBody QrDto qrDto) {
        String fileName = "temp." + qrDto.getFileType();
        AppUtil.deleteFile("temp.png");
        boolean[][] blob = generator.generate(qrDto.getSize(), qrDto.getContent());
        BufferedImage image = convertor.convert(blob, qrDto.getSize());
        File file = writeQrToFile(qrDto.getFileType(), image);
        Qr qr = setQr(qrDto, file);
        repository.save(qr);
    }

    private Qr setQr(@RequestBody QrDto content, File file) {
        Qr qr = new Qr();
        qr.setContent(cryptographer.encrypt(content.getContent()));
        qr.setQr(new byte[(int) file.length()]);
        return qr;
    }

    private File writeQrToFile(String fileType, BufferedImage image) {
        String fileName = "temp." + fileType;
        File file = new File(fileName);
        try {
            ImageIO.write(image, fileType, file);
        } catch (IOException e) {
            logger.error(e);
        }
        return file;
    }

} 
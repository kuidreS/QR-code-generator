package com.vserdiuk.qr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vserdiuk on 12/28/17.
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

} 
package com.stuwxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther Wangxq
 * @date2020/11/1011:14
 */
@Controller
public class MusicShowController {
    @GetMapping("/music")
    public String about() {
        return "music";
    }
}

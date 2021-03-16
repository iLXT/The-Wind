package com.stuwxq.controller;

import com.stuwxq.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther Wangxq
 * @date2021/3/1411:22
 */
@Controller
public class PictureShowController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String friends(Model model) {
        model.addAttribute("pictures",pictureService.listPicture());
        return "picture";
    }

}

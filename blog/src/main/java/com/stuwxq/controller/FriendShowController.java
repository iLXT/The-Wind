package com.stuwxq.controller;

import com.stuwxq.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther Wangxq
 * @date2020/12/1118:16
 */
@Controller
public class FriendShowController {
    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String friends(Model model) {
        model.addAttribute("friendlinks",friendLinkService.listFriendLink());
        return "friends";
    }
}

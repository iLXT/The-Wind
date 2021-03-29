package com.stuwxq.controller;

import com.stuwxq.pojo.Blog;
import com.stuwxq.queryvo.BlogQuery;
import com.stuwxq.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        List<Blog> blogs = blogService.getAllBlog1();
        model.addAttribute("blogs", blogs);
        model.addAttribute("blogCount", blogService.getAllBlogCount());
        return "archives";
    }
}

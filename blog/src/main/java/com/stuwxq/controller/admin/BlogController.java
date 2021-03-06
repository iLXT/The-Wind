package com.stuwxq.controller.admin;

import com.stuwxq.pojo.Blog;
import com.stuwxq.pojo.BlogAndTag;
import com.stuwxq.pojo.Tag;
import com.stuwxq.pojo.User;
import com.stuwxq.queryvo.BlogQuery;
import com.stuwxq.queryvo.SearchBlog;
import com.stuwxq.service.BlogService;
import com.stuwxq.service.TagService;
import com.stuwxq.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    public void setTypeAndTag(Model model) {
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("tags", tagService.getAllTag());
    }

    @GetMapping("/blogs")  //后台显示博客列表
    public String blogs(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model){
        PageHelper.startPage(pagenum, 5);
        List<BlogQuery> allBlog = blogService.getAllBlogQuery();
        //得到分页结果对象
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(allBlog);
        model.addAttribute("pageInfo", pageInfo);
        setTypeAndTag(model);  //查询类型和标签
        return "admin/blogs";
    }

    //    搜索博客
    @PostMapping("/blogs/search")
    public String search(SearchBlog searchBlog, Model model,
                         @RequestParam(defaultValue = "1",value = "pagenum") Integer pagenum) {
        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);
        PageHelper.startPage(pagenum, 5);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogs::blogList";
    }

    @GetMapping("/blogs/input") //去新增博客页面
    public String toAddBlog(Model model){
        model.addAttribute("blog", new Blog());  //返回一个blog对象给前端th:object
        setTypeAndTag(model);
        return "admin/blogs-input";
    }

    @GetMapping("/blogs/{id}/input") //去编辑博客页面
    public String toEditBlog(@PathVariable Long id, Model model){
        Blog blog = blogService.getBlog(id);
        blog.init();   //将tags集合转换为tagIds字符串
        model.addAttribute("blog", blog);     //返回一个blog对象给前端th:object
        setTypeAndTag(model);
        return "admin/blogs-input";
    }

    @PostMapping("/blogs") //新增、编辑博客
    public String addBlog(Blog blog, HttpSession session, RedirectAttributes attributes){
        //设置user属性
        blog.setUser((User) session.getAttribute("user"));
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        //设置blog的type
        blog.setType(typeService.getType(blog.getType().getId()));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //给blog中的List<Tag>赋值
        List<Tag> newlist=tagService.getTagByString(blog.getTagIds());
        blog.setTags(newlist);
        blog.setTagIds(blog.getTagIds());
        if (blog.getId() == null) {   //id为空，则为新增
            blogService.saveBlog(blog);
        } else {
            blogService.updateBlog(blog);
            List<Tag> oldlist = tagService.getTagsList(blog.getId());
            for (Tag tag: oldlist) {
                if (!newlist.contains(tag)){
                    blogService.deleteTags(tag.getId(),blog.getId());
                }
            }
        }
        attributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/delete")
    public String deleteBlogs(@PathVariable Long id, RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/blogs";
    }
}

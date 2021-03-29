package com.stuwxq.service;

import com.stuwxq.pojo.Blog;
import com.stuwxq.pojo.BlogAndTag;
import com.stuwxq.pojo.Tag;
import com.stuwxq.queryvo.BlogQuery;
import com.stuwxq.queryvo.SearchBlog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog getBlog(Long id);  //后台展示博客

    Blog getDetailedBlog(Long id);  //前端展示博客

    List<Blog> getAllBlog1();

    List<BlogQuery> getAllBlogQuery();

    List<BlogQuery> getBlogBySearch(SearchBlog searchBlog);

    List<Blog> getByTypeId(Long typeId);  //根据类型id获取博客

    List<Blog> getByTagId(Long tagId);  //根据标签id获取博客

    List<Blog> getIndexBlog();  //主页博客展示

    List<Blog> getAllRecommendBlog();  //推荐博客展示

    List<Blog> getSearchBlog(String query);  //全局搜索博客

    int getAllBlogCount(); //查询博客条数

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    int getBlogCommentTotalById(Long id);

    int deleteTags(Long tid,Long bid);






}

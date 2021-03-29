package com.stuwxq.dao;

import com.stuwxq.pojo.Blog;
import com.stuwxq.pojo.BlogAndTag;
import com.stuwxq.pojo.Tag;
import com.stuwxq.queryvo.BlogQuery;
import com.stuwxq.queryvo.SearchBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogDao {
    //获取指定博客
    Blog getBlog(Long id);
    //查询文章管理列表
    List<BlogQuery> getAllBlogQuery();
    //后台条件查询
    List<BlogQuery> searchByTitleOrType(SearchBlog searchBlog);
    //根据类型id获取博客
    List<Blog> getByTypeId(Long typeId);
    //根据标签id获取博客
    List<Blog> getByTagId(Long tagId);
    //博客保存
    int saveBlog(Blog blog);
    //保存BlogAndTag
    int saveBlogAndTag(BlogAndTag blogAndTag);
    //更新博客
    int updateBlog(Blog blog);
    //删除博客
    int deleteBlog(Long id);




    //查询所有博客按创建时间排序
    List<Blog> getAllBlog1();
    //主页博客展示
    List<Blog> getIndexBlog();
    //推荐博客展示
    List<Blog> getAllRecommendBlog();
    //全局搜索博客
    List<Blog> getSearchBlog(String query);
    //博客详情
    Blog getDetailedBlog(@Param("id") Long id);
    //更新访问数
    int updateViews(Long id);
    //得到博客总数
    int getAllBlogCount();
    //删除BlogAndTag中不需要的标签
    int deleteTags(Long tid,Long bid);
    //得到指定博客的所有评论数
    int getBlogCommentTotalById(Long id);
    //得到BlogAndTag对象
    int getBlogAndTag(Long tid,Long bid);



}

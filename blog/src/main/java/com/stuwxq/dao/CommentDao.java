package com.stuwxq.dao;

import com.stuwxq.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {

    //根据创建时间倒序来排
    List<Comment> findByBlogIdAndParentCommentNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);

    //查询父级对象
    Comment findByParentCommentId(@Param("parentCommentId")Long parentcommentid);

    //查询我自己
    Comment findById(@Param("Id")Long id);


    //添加一个评论
    int saveComment(Comment comment);

    //删除评论
    int deleteComment(Comment comment);

    //根据父级Id查询对象子对象
    List<Comment> findSecondaryCommentBySelfId(@Param("commentId") Long commentId);
}

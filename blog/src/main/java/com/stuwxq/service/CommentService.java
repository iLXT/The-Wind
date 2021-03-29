package com.stuwxq.service;

import com.stuwxq.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

    int deleteComment(Comment comment);
}

package com.stuwxq.dao;

import com.stuwxq.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther Wangxq
 * @date2020/12/1110:49
 */
@Mapper
@Repository
public interface MessageDao {

    //添加一条留言
    int saveMessage(Message message);

    //查询父级留言
    List<Message> findByParentIdNull(@Param("ParentId") Long ParentId);

    //查询一级回复
    List<Message> findByParentIdNotNull(@Param("id") Long id);

    //查询二级以及所有子集回复
    List<Message> findByReplayId(@Param("childId") Long childId);

    //删除留言
    void deleteMessage(Long id);
    //得到留言数
    int getMessageTotal();
}

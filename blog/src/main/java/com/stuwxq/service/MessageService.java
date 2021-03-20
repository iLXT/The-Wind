package com.stuwxq.service;

import com.stuwxq.pojo.Message;

import java.util.List;

/**
 * @auther Wangxq
 * @date2020/12/1110:51
 */
public interface MessageService {
    //查询留言列表
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);

    int getMessageTotal();
}

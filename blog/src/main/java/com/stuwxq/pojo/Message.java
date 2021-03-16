package com.stuwxq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther Wangxq
 * @date2020/12/1110:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentMessageId;
    private boolean adminMessage;

    //回复评论
    private List<Message> replyMessages = new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;
}

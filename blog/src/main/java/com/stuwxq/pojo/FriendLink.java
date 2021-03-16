package com.stuwxq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther Wangxq
 * @date2020/12/1117:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendLink {
    private Long id;
    private String blogname;
    private String blogaddress;
    private String pictureaddress;
    private Date createTime;
}

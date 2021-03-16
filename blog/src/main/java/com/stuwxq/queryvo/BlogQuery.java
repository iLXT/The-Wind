package com.stuwxq.queryvo;

import com.stuwxq.pojo.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther Wangxq
 * @date2020/10/2116:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogQuery {
    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;
}

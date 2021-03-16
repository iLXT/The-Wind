package com.stuwxq.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther Wangxq
 * @date2020/10/2116:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchBlog {
    private String title;
    private Long typeId;
}

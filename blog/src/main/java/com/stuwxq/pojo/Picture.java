package com.stuwxq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther Wangxq
 * @date2021/3/1411:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    private Long id;
    private String picturename;
    private String picturetime;
    private String pictureaddress;
    private String picturedescription;
}

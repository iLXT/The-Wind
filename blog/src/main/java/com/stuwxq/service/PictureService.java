package com.stuwxq.service;

import com.stuwxq.pojo.Picture;

import java.util.List;

/**
 * @auther Wangxq
 * @date2021/3/1411:20
 */

public interface PictureService {

    //查询照片
    List<Picture> listPicture();

    //添加图片
    int savePicture(Picture picture);

    //根据id查询照片
    Picture getPicture(Long id);

    //    编辑修改相册
    int updatePicture(Picture picture);

    //    删除照片
    void deletePicture(Long id);

}

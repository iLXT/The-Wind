package com.stuwxq.dao;

import com.stuwxq.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther Wangxq
 * @date2021/3/1411:19
 */
@Mapper
@Repository
public interface PictureDao {
    List<Picture> listPicture();

    int savePicture(Picture picture);

    Picture getPicture(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);
}

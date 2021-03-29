package com.stuwxq.dao;

import com.stuwxq.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagDao {
    //保存标签
    int saveTag(Tag tag);
    //得到指定id的标签
    Tag getTag(Long id);
    //得到指定名称的id以进行查重操作
    Tag getTagByName(String name);
    //更新标签
    int updateTag(Tag tag);
    //删除标签
    int deleteTag(Long id);

    //得到所有标签
    List<Tag> getAllTag();

    //首页展示博客标签
    List<Tag> getBlogTag();
    //获取中间表标签集合
    List<Tag> getTagsList(Long id);
}

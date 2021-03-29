package com.stuwxq.dao;

import com.stuwxq.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDao {
    //保存分类
    int saveType(Type type);
    //获取指定id分类
    Type getType(Long id);
    //获取指定名称的分类
    Type getTypeByName(String name);
    //更新分类
    int updateType(Type type);
    //删除标签
    int deleteType(Long id);
    //得到所有类型
    List<Type> getAllType();
    //首页右侧展示type对应的博客数量
    List<Type> getBlogType();


}

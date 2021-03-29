package com.stuwxq.dao;

import com.stuwxq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    //获取User信息
    User queryUserByName(@Param("username")String username);
}

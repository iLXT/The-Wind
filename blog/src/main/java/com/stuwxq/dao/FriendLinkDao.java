package com.stuwxq.dao;

import com.stuwxq.pojo.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther Wangxq
 * @date2020/12/1117:51
 */
@Mapper
@Repository
public interface FriendLinkDao {
    List<FriendLink> listFriendLink();

    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLink(Long id);

    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);

}

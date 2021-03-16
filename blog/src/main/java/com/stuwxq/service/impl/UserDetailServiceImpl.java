package com.stuwxq.service.impl;

import com.stuwxq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @auther Wangxq
 * @date2021/2/1219:44
 */
@Service

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取session，设置user到session
        HttpSession session = request.getSession();
        //1.根据用户名去数据库查询，如果不存在，则抛出异常
        User user = userService.queryUserByName(username);
        if (user==null) {
            throw new BadCredentialsException("账号不存在，请重新输入");
        }else {
           // String encodePwd = passwordEncoder.encode(user.getPassword());//密码：123456
            //System.out.println("加密后密码：" + encodePwd);
            session.setAttribute("user", user);
            String perms = user.getPerms();
            return new org.springframework.security.core.userdetails.User(username, user.getPassword(), getAuthorities(perms));

        }

    }
    private Collection<GrantedAuthority> getAuthorities(String perms){

        List<String> permsLists = Arrays.asList(perms.split(","));

        List<GrantedAuthority> arrayList = new ArrayList<>();

        for (String perm : permsLists) {
            arrayList.add(new SimpleGrantedAuthority(perm));
        }
        return arrayList;
    }
}

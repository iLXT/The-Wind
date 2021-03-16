package com.stuwxq.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther Wangxq
 * @date2021/1/1710:21
 */
public interface SecurityService {
    boolean hasPermission(HttpServletRequest httpServletRequest, Authentication authentication);
}

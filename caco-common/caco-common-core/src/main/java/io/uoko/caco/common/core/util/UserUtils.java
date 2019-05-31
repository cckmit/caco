/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：UserUtils
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.util;

import com.alibaba.ttl.TransmittableThreadLocal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.uoko.caco.common.core.constant.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

/**
 * 请使用 uoko-framework-base-biz 中的UserUtil获取包工具
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Slf4j
public class UserUtils {
    private static final ThreadLocal<String> THREAD_LOCAL_USER = new TransmittableThreadLocal<>();

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @param httpServletRequest request
     * @return 角色名
     */
    public static List<String> getRole(HttpServletRequest httpServletRequest) throws RuntimeException {
        String token = getToken(httpServletRequest);
        String key = Base64.getEncoder().encodeToString(CommonConstants.SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        List<String> roleNames = (List<String>) claims.get("authorities");
        return roleNames;
    }

    /**
     * 根据header中的token获取用户ID
     *
     * @param httpServletRequest
     * @return 用户ID
     */
    public static String getUserId(HttpServletRequest httpServletRequest) throws RuntimeException {
        String token = getToken(httpServletRequest);
        String key = Base64.getEncoder().encodeToString(CommonConstants.SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return (String) claims.get("userId");
    }

    /**
     * 根据header中的token获取授权ID
     *
     * @param httpServletRequest
     * @return 用户ID
     */
    public static String getAuthId(HttpServletRequest httpServletRequest) throws RuntimeException {
        String token = getToken(httpServletRequest);
        String key = Base64.getEncoder().encodeToString(CommonConstants.SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return (String) claims.get("authId");
    }

    /**
     * 根据header中的token获取授权名
     *
     * @param httpServletRequest
     * @return 获取授权名
     */
    public static String getIdentifier(HttpServletRequest httpServletRequest) throws RuntimeException {
        String token = getToken(httpServletRequest);
        String key = Base64.getEncoder().encodeToString(CommonConstants.SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return (String) claims.get("identifier");
    }

    /**
     * 获取请求中token
     *
     * @param httpServletRequest request
     * @return token
     */
    public static String getToken(HttpServletRequest httpServletRequest) throws RuntimeException {
        String authorization = httpServletRequest.getHeader(CommonConstants.REQ_HEADER);
        return StringUtils.substringAfter(authorization, CommonConstants.TOKEN_SPLIT);
    }

    /**
     * 设置用户信息
     *
     * @param userId 用户id
     */
    public static void setUser(String userId) throws RuntimeException {
        THREAD_LOCAL_USER.set(userId);
        MDC.put(CommonConstants.KEY_USER, userId);
    }

    /**
     * 从threadlocal 获取用户名
     *
     * @return 用户名
     */

    public static String getUser() throws RuntimeException {
        return THREAD_LOCAL_USER.get();
    }

    /**
     * 清楚全部的用户信息
     *
     * @return
     * @author shaohua
     * @date 10:11 2019/3/20
     */
    public static void clearAllUserInfo() throws RuntimeException {
        THREAD_LOCAL_USER.remove();
        MDC.remove(CommonConstants.KEY_USER);
    }
}

/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：SecurityConstants
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.auth.biz.constant;

/**
 * <p>
 * io.uoko.caco.auth 静态常量
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
public interface SecurityConstants {
    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     * JdbcClientDetailsService 查询语句
     */
    String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

    /**
     * username 授权地址
     */
    String OAUTH2_TOKEN_URL = "/oauth/token";

    /**
     * 删除
     */
    String STATUS_DEL = "1";
    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * token-uservo
     */
    String TOKEN_USER_DETAIL = "token-user-detail";
    /**
     * token请求头名称
     */
    String REQ_HEADER = "Authorization";

    /**
     * token分割符
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * jwt签名
     */
    String SIGN_KEY = "UOKO";

    /**
     * 路由信息Redis保存的key
     */
    String ROUTE_KEY = "_ROUTE_KEY";


    /**
     * 基础用户
     */
    String BASE_ROLE = "ROLE_USER";

    /**
     * 授权码模式
     */
    String AUTHORIZATION_CODE = "authorization_code";
    /**
     * 密码模式
     */
    String PASSWORD = "password";
    /**
     *
     */
    String GRANT_TYPE = "grant_type";
    /**
     * 刷新token
     */
    String REFRESH_TOKEN = "refreshToken";

    /**
     * oauth token
     */
    String OAUTH_TOKEN_URL = "/oauth/**";

    /**
     * LICENSE
     */
    String LICENSE = "MADE BY UOKO";

    /**
     * 存放token的redis前缀
     */
    String TOKEN_REDIS_PREFIX = "uk_token_";
    /**
     * 客户端加密头部
     */
    String BASIC_ = "Basic ";

}

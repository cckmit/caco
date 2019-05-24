/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：CommonConstants
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/24
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.gateway.constant;

/**
 * <p>
 * 网管常量
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/24
 */
public interface CommonConstants {

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
    String SIGN_KEY = "uoko";
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
     * 路由信息Redis保存的key
     */
    String ROUTE_KEY = "_ROUTE_KEY";

    /**
     * 权限忽略的地址存储
     */
    String IGNORE_URL_KEY = "_IGNORE_URL_KEY";

    /**
     * 匿名用户
     */
    String ANONYMOUS_USER = "anonymousUser";

    /**
     * 公共用户
     */
    String ROLE_USER = "ROLE_USER";
}

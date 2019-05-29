/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：Constants
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.constant;

/**
 * <p>
 * 常量
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
public interface Constants {
    /**
     * ttl 存储用户userId 的key
     */
    String KEY_USER = "uoko_user_id";
    /**
     * jwt签名
     */
    String SIGN_KEY = "UOKO";
    /**
     * token请求头名称
     */
    String REQ_HEADER = "Authorization";

    /**
     * token分割符
     */
    String TOKEN_SPLIT = "Bearer ";
}

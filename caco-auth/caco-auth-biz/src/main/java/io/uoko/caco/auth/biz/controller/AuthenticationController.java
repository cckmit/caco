/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：AuthenticationController
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.auth.biz.controller;

import cn.hutool.core.util.StrUtil;
import io.uoko.caco.common.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>
 * 退出登录
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@RestController
@RequestMapping("token")
public class AuthenticationController {
    @Autowired
    private TokenStore tokenStore;

    /**
     * 清除缓存
     *
     * @param accessToken 授权token
     * @return
     */
    @DeleteMapping("token/{accessToken}")
    public Boolean removeToken(@PathVariable("accessToken") String accessToken) {
        OAuth2AccessToken auth2AccessToken = tokenStore.readAccessToken(accessToken);
        if (auth2AccessToken == null || StrUtil.isBlank(auth2AccessToken.getValue())) {
            throw new BusinessException("退出失败，token 无效");
        }
        tokenStore.removeAccessToken(auth2AccessToken);

        OAuth2RefreshToken oAuth2RefreshToken = auth2AccessToken.getRefreshToken();
        tokenStore.removeRefreshToken(oAuth2RefreshToken);
        return new AtomicBoolean(true).get();
    }
}

/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：AuthServiceFallbackImpl
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.auth.biz.api.fegin.fallback;

import io.uoko.caco.auth.biz.api.domain.dto.TokenDTO;
import io.uoko.caco.auth.biz.api.fegin.AuthService;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>
 * AuthService fallback
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
@Slf4j
@Component
public class AuthServiceFallbackImpl implements AuthService {

    @lombok.Setter
    private Throwable throwable;



    @Override
    public TokenDTO postAccessToken(String authorization, Map<String, String> parameters) {
        log.error("Feign 授权登录/刷新token错误", throwable);
        return null;
    }

    @Override
    public Boolean removeToken(String accessToken) {
        log.error("Feign 移除token错误", throwable);
        return null;
    }
}

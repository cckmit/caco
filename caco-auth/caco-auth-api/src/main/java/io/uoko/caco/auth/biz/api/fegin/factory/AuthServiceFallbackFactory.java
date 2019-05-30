/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：AuthServiceFallbackFactory
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.auth.biz.api.fegin.factory;

import feign.hystrix.FallbackFactory;
import io.uoko.caco.auth.biz.api.fegin.AuthService;
import io.uoko.caco.auth.biz.api.fegin.fallback.AuthServiceFallbackImpl;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Auth Service Feign Factory
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
@Component
public class AuthServiceFallbackFactory implements FallbackFactory<AuthService> {

    @Override
    public AuthService create(Throwable throwable) {
        AuthServiceFallbackImpl authServiceFallback = new AuthServiceFallbackImpl();
        authServiceFallback.setThrowable(throwable);
        return authServiceFallback;
    }
}

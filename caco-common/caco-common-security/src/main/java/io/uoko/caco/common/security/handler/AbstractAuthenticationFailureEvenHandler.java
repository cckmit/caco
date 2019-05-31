/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：AbstractAuthenticationFailureEvenHandler
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.security.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 * 认证失败事件处理器
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
public abstract class AbstractAuthenticationFailureEvenHandler implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent abstractAuthenticationFailureEvent) {
        AuthenticationException authenticationException = abstractAuthenticationFailureEvent.getException();
        Authentication authentication = (Authentication) abstractAuthenticationFailureEvent.getSource();
        handle(authenticationException, authentication);
    }


    /**
     * 处理登录成功方法
     * <p>
     *
     * @param authenticationException 登录的authentication 对象
     * @param authentication          登录的authenticationException 对象
     */
    public abstract void handle(AuthenticationException authenticationException, Authentication authentication);

}

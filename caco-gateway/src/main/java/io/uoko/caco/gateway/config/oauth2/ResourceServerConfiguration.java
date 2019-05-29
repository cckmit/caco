/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：ResourceServerConfiguration
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/24
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.gateway.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

/**
 * <p>
 * 配置资源 ---- 资源服务器
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/24
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private FilterIgnoreProperties filterIgnoreProperties;
    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;
    @Autowired
    private UokoAccessDeniedHandler uokoAccessDeniedHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
//        http.headers().frameOptions().disable();
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>
//                .ExpressionInterceptUrlRegistry registry = http
//                .csrf().disable().exceptionHandling().authenticationEntryPoint(new CustomerAuthenticationEntryPoint())
//                .accessDeniedHandler(new CustomerAccessDeniedHandler()).and().authorizeRequests();
//        filterIgnorePropertiesConfig.getUrls()
//                .forEach(url -> registry.antMatchers(url).permitAll());
//        registry.anyRequest();
//        registry.anyRequest()
//                .access("@permissionService.hasPermission(request,authentication)");
        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
        http.headers().frameOptions().disable();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                .ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();
        filterIgnoreProperties.getUrls()
                .forEach(url -> registry.antMatchers(url).permitAll());
        registry.anyRequest().authenticated()
                .and().csrf().disable();
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.expressionHandler(expressionHandler);
        resources.accessDeniedHandler(uokoAccessDeniedHandler);
    }

    /**
     * 配置解决 spring-security-oauth问题
     * https://github.com/spring-projects/spring-security-oauth/issues/730
     *
     * @param applicationContext ApplicationContext
     * @return OAuth2WebSecurityExpressionHandler
     */
    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }

    /**
     * 加密方式
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}

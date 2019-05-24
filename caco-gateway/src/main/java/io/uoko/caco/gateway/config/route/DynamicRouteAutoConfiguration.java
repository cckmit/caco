/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：DynamicRouteConfiguration
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/24
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.gateway.config.route;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>
 * 动态路由配置
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/24
 */
@Configuration
public class DynamicRouteAutoConfiguration {
    private Registration registration;
    private DiscoveryClient discoveryClient;
    private ZuulProperties zuulProperties;
    private ServerProperties serverProperties;
    private RedisTemplate redisTemplate;

    public DynamicRouteAutoConfiguration(Registration registration, DiscoveryClient discoveryClient,
                                     ZuulProperties zuulProperties, ServerProperties serverProperties,
                                     RedisTemplate redisTemplate) {
        this.registration = registration;
        this.discoveryClient = discoveryClient;
        this.zuulProperties = zuulProperties;
        this.serverProperties = serverProperties;
        this.redisTemplate = redisTemplate;
    }


    /**
     * DiscoveryClientRouteLocator 注入，自带刷新
     *
     * @return
     */
    @Bean
    public DynamicRouteLocator routeLocator() {
        return new DynamicRouteLocator(
                serverProperties.getServlet().getPath()
                , discoveryClient
                , zuulProperties
                , registration
                , redisTemplate);
    }
}

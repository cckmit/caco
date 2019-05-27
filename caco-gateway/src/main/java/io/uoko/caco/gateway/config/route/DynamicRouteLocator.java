///*
// * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
// * 项目名称：UOKO 系统
// * 类名称：DynamicRouteLocator
// * 创建人：绍华(for dingtalk)
// * 联系方式：uokoer@gmail.com
// * 创建时间：2019/5/24
// * 项目官网: https://uoko.io
// */
//package io.uoko.caco.gateway.config.route;
//
//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.core.util.StrUtil;
//import io.uoko.caco.gateway.constant.CommonConstants;
//import io.uoko.caco.gateway.domain.entity.SysGatewayRouteEntity;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
//import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///**
// * <p>
// * 动态路由实现，包含刷新和初始化路由，
// * 1.consul 动态检查如有服务器变更，更新zuul配置
// * 2.手动触发更新zuul路由配置
// * 3.更新范围： application配置文件路由规则，db(mysql->redis)，consul 原配置的路由
// * </p>
// *
// * @author uokoer
// * Email uokoer@gmail.com
// * Website https://uoko.io
// * created by 2019/5/24
// */
//@Slf4j
//public class DynamicRouteLocator extends DiscoveryClientRouteLocator {
//    private final ZuulProperties properties;
//    private final RedisTemplate redisTemplate;
//
//    public DynamicRouteLocator(String servletPath, DiscoveryClient discovery,
//                               ZuulProperties properties, ServiceInstance localServiceInstance,
//                               RedisTemplate redisTemplate) {
//        super(servletPath, discovery, properties, localServiceInstance);
//        this.properties = properties;
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Override
//    protected LinkedHashMap<String, ZuulProperties.ZuulRoute> locateRoutes() {
//        //读取properties配置、consul默认配置
//        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap =
//                new LinkedHashMap<>(super.locateRoutes());
//        log.info("初始默认的路由配置完成");
//        routesMap.putAll(locateRoutesFromDb());
//        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
//        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {
//            String path = entry.getKey();
//            if (!path.startsWith("/")) {
//                path = "/" + path;
//            }
//            if (StringUtils.isNotBlank(this.properties.getPrefix())) {
//                path = this.properties.getPrefix() + path;
//                if (!path.startsWith("/")) {
//                    path = "/" + path;
//                }
//            }
//            values.put(path, entry.getValue());
//        }
//        return values;
//    }
//
//    /**
//     * Redis中保存的
//     *
//     * @return
//     */
//    private Map<String, ZuulProperties.ZuulRoute> locateRoutesFromDb() {
//        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
//
//        Object obj = redisTemplate.opsForValue().get(CommonConstants.ROUTE_KEY);
//        if (obj == null) {
//            return routes;
//        }
//
//        List<SysGatewayRouteEntity> results = (List<SysGatewayRouteEntity>) obj;
//        for (SysGatewayRouteEntity entity : results) {
//            if (StringUtils.isBlank(entity.getPath()) && StringUtils.isBlank(entity.getUrl())) {
//                continue;
//            }
//
//            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
//            try {
//                zuulRoute.setId(entity.getServiceId());
//                zuulRoute.setPath(entity.getPath());
//                zuulRoute.setServiceId(entity.getServiceId());
//                zuulRoute.setRetryable("0".equals(entity.getRetryAble()) ? Boolean.FALSE : Boolean.TRUE);
//                zuulRoute.setStripPrefix("0".equals(entity.getStripPrefix()) ? Boolean.FALSE : Boolean.TRUE);
//                zuulRoute.setUrl(entity.getUrl());
//                List<String> sensitiveHeadersList = StrUtil.splitTrim(entity.getSensitiveHeadersList(), ",");
//                if (sensitiveHeadersList != null) {
//                    Set<String> sensitiveHeaderSet = CollUtil.newHashSet();
//                    sensitiveHeaderSet.addAll(sensitiveHeadersList);
//                    zuulRoute.setSensitiveHeaders(sensitiveHeaderSet);
//                    zuulRoute.setCustomSensitiveHeaders(true);
//                }
//            } catch (Exception e) {
//                log.error("从数据库加载路由配置异常", e);
//            }
//            log.info("添加数据库自定义的路由配置,path：{}，serviceId:{}", zuulRoute.getPath(), zuulRoute.getServiceId());
//            routes.put(zuulRoute.getPath(), zuulRoute);
//        }
//        return routes;
//    }
//}

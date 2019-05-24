/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：RegistrySwaggerResourcesProvider
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/24
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.gateway.config.swagger;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * routeLocator 聚合swagger
 * 1.从路由中获取配置的地址和serviceid绑定
 * 2.跳过不需要认证的服务 如：认证服务 ...
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/24
 */
public class RegistrySwaggerResourcesProvider implements SwaggerResourcesProvider {

    @Autowired
    private  RouteLocator routeLocator;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> swaggerResources = new ArrayList<>();
        /*
        如果配置
        zuul:
           ignoredServices: '*'
         将会只读配置路由规则的服务，
        如果没有配置将会将所有路由总的服务swagger显示出来；
        如果想付略某些服务不现实，
         */
        // TODO: 2019/5/24 写成配置，付略不现实swagger的文档
        routeLocator.getRoutes().forEach(route -> {
            swaggerResources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs")));
        });

        return swaggerResources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}

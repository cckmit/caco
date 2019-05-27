/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：SwaggerAutoConfiguration
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/24
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.gateway.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p>
 * zuul swagger 装配
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/24
 */
@Configuration
public class SwaggerAutoConfiguration {

    @Primary
    @Bean
    public RegistrySwaggerResourcesProvider registrySwaggerResourcesProvider() {
        return new RegistrySwaggerResourcesProvider();
    }
}

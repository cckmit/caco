/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：EnableCacoResourceServer
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.security.annotation;

import io.uoko.caco.common.security.component.CacoResourceServerAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * <p>
 * 资源服务注解
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({CacoResourceServerAutoConfiguration.class})
public @interface EnableCacoResourceServer {
}

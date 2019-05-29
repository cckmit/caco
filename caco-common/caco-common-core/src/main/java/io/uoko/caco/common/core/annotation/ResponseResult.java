/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：ResponseResult
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.annotation;

import io.uoko.caco.common.core.result.PlatformResult;
import io.uoko.caco.common.core.result.Result;

import java.lang.annotation.*;

/**
 * <p>
 * 接口返回结果增强  会通过拦截器拦截后放入标记，在WebResponseBodyHandler进行结果处理
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
    Class<? extends Result> value() default PlatformResult.class;
}

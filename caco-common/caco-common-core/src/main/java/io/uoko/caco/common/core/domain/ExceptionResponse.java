/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：ExceptionResponse
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.domain;

import lombok.Data;

import java.io.Serializable;


/**
 * <p>
 *
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Data
public class ExceptionResponse implements Serializable {

    private String code;
    private String exception;
    private String msg;
    private String data;

}

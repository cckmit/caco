/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：GlobalExceptionHandler
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.handler;


import io.uoko.caco.common.core.exception.BusinessException;
import io.uoko.caco.common.core.result.DefaultErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * <p>
 * 统一异常处理
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Slf4j
@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends BaseGlobalExceptionHandler {

    /**
     * 处理400类异常
     */
    @Override
    @ExceptionHandler(ConstraintViolationException.class)
    public DefaultErrorResult handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @Override
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public DefaultErrorResult handleConstraintViolationException(HttpMessageNotReadableException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @Override
    @ExceptionHandler(BindException.class)
    public DefaultErrorResult handleBindException(BindException e, HttpServletRequest request) {
        return super.handleBindException(e, request);
    }

    @Override
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DefaultErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        return super.handleMethodArgumentNotValidException(e, request);
    }

    /**
     * 处理自定义异常
     */
    @Override
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<DefaultErrorResult> handleBusinessException(BusinessException e, HttpServletRequest request) {
        return super.handleBusinessException(e, request);
    }

    /**
     * 处理运行时异常
     */
    @Override
    @ExceptionHandler(Throwable.class)
    public DefaultErrorResult handleThrowable(Throwable e, HttpServletRequest request) {
        return super.handleThrowable(e, request);
    }


}

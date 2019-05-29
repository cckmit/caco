/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：DefaultErrorResult
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.result;

import io.uoko.caco.common.core.domain.enums.BusinessExceptionEnum;
import io.uoko.caco.common.core.domain.enums.ResultCode;
import io.uoko.caco.common.core.exception.BusinessException;
import io.uoko.caco.common.core.util.RequestContextUtils;
import io.uoko.caco.common.core.util.StringUtils;
import lombok.Data;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * <p>
 * 默认全局错误返回结果
 * 备注：该返回信息是spring boot的默认异常时返回结果{@link DefaultErrorAttributes}，目前也是我们服务的默认返回结果
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Data
public class DefaultErrorResult implements Result {


    private static final long serialVersionUID = 1899083570489722793L;

    /**
     * HTTP响应状态码 {@link HttpStatus}
     */
    private Integer status;

    /**
     * HTTP响应状态码的英文提示
     */
    private String error;

    /**
     * 异常堆栈的精简信息
     */
    private String msg;

    /**
     * 我们系统内部自定义的返回值编码，{@link ResultCode} 它是对错误更加详细的编码
     * <p>
     * 备注：spring boot默认返回异常时，该字段为null
     */
    private String code;

    /**
     * 调用接口路径
     */
    private String path;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 异常的错误传递的数据
     */
    private Object errors;

    /**
     * 时间戳
     */
    private Date timestamp;

    public static DefaultErrorResult failure(ResultCode resultCode, Throwable e, HttpStatus httpStatus, Object errors) {
        DefaultErrorResult result = DefaultErrorResult.failure(resultCode, e, httpStatus);
        result.setErrors(errors);
        return result;
    }

    public static DefaultErrorResult failure(ResultCode resultCode, Throwable e, HttpStatus httpStatus) {
        DefaultErrorResult result = new DefaultErrorResult();
        result.setCode(resultCode.code());
        result.setMsg(resultCode.message());
        result.setStatus(httpStatus.value());
        result.setError(httpStatus.getReasonPhrase());
        result.setException(e.getClass().getName());
        String path = RequestContextUtils.getRequest().getRequestURI();
        result.setPath(path);
        result.setTimestamp(new Date());
        return result;
    }

    public static DefaultErrorResult failureException(BusinessException e) {

        BusinessExceptionEnum ee = BusinessExceptionEnum.getByEClass(e.getClass());
        if (ee != null) {
            return DefaultErrorResult.failure(ee.getResultCode(), e, ee.getHttpStatus(), e.getData());
        }
        DefaultErrorResult defaultErrorResult = DefaultErrorResult.failure(e.getResultCode() == null ?
                ResultCode.SUCCESS : e.getResultCode(), e, HttpStatus.SERVICE_UNAVAILABLE, e.getData());
        if (StringUtils.isNotEmpty(e.getMessage())) {
            defaultErrorResult.setMsg(e.getMessage());
        }
        if (StringUtils.isNotEmpty(e.getCode())) {
            defaultErrorResult.setCode(e.getCode());
        }
        return defaultErrorResult;
    }


    public static DefaultErrorResult failure(BusinessException e) {
        BusinessExceptionEnum ee = BusinessExceptionEnum.getByEClass(e.getClass());
        if (ee != null) {
            return DefaultErrorResult.failure(ee.getResultCode(), e, ee.getHttpStatus(), e.getData());
        }

        DefaultErrorResult defaultErrorResult = DefaultErrorResult.failure(e.getResultCode() == null ? ResultCode.SUCCESS : e.getResultCode(), e, HttpStatus.OK, e.getData());
        if (StringUtils.isNotEmpty(e.getMessage())) {
            defaultErrorResult.setMsg(e.getMessage());
        }
        if (StringUtils.isNotEmpty(e.getCode())) {
            defaultErrorResult.setCode(e.getCode());
        }
        return defaultErrorResult;
    }


}

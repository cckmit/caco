/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：BusinessException
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.exception;

import io.uoko.caco.common.core.domain.enums.BusinessExceptionEnum;
import io.uoko.caco.common.core.domain.enums.ResultCode;
import io.uoko.caco.common.core.util.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 业务异常类
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 2924803567049479380L;

    protected String code;

    protected String message;

    protected ResultCode resultCode;

    protected Object data;

    public BusinessException() {
        BusinessExceptionEnum exceptionEnum = BusinessExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            resultCode = exceptionEnum.getResultCode();
            code = exceptionEnum.getResultCode().code();
            message = exceptionEnum.getResultCode().message();
        } else {
            resultCode = ResultCode.SYSTEM_UNDEFINED_ERROR;
            code = ResultCode.SYSTEM_UNDEFINED_ERROR.code();
            message = ResultCode.SYSTEM_UNDEFINED_ERROR.message();
        }
    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(String format, Object... objects) {
        this();
        this.message = StringUtils.formatIfArgs(format, "{}", objects);
    }

    public BusinessException(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

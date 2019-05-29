/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：RemoteAccessException
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.exception;


import io.uoko.caco.common.core.domain.enums.ResultCode;

/**
 * <p>
 * 远程访问异常
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
public class RemoteAccessException extends BusinessException {

    private static final long serialVersionUID = -832464574076215195L;

    public RemoteAccessException() {
        super();
    }

    public RemoteAccessException(String code, String message) {
        super(code, message);
    }

    public RemoteAccessException(Object data) {
        super.data = data;
    }

    public RemoteAccessException(ResultCode resultCode) {
        super(resultCode);
    }

    public RemoteAccessException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public RemoteAccessException(String msg) {
        super(msg);
    }

    public RemoteAccessException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }

}

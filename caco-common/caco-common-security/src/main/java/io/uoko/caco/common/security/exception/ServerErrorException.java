/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：ServerErrorException
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.uoko.caco.common.security.component.CacoAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * <p>
 * 服务内部错误异常
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
@JsonSerialize(using = CacoAuth2ExceptionSerializer.class)
public class ServerErrorException extends CacoAuth2Exception {

    public ServerErrorException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "server_error";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

}

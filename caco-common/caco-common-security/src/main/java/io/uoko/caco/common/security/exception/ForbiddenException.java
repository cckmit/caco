/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：ForbiddenException
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
 * 禁止访问
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
@JsonSerialize(using = CacoAuth2ExceptionSerializer.class)
public class ForbiddenException extends CacoAuth2Exception {

    public ForbiddenException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "access_denied";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.FORBIDDEN.value();
    }

}

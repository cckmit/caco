/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：CacoAuth2Exception
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.uoko.caco.common.security.component.CacoAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * <p>
 * 自定义OAuth2Exception
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
@JsonSerialize(using = CacoAuth2ExceptionSerializer.class)
public class CacoAuth2Exception extends OAuth2Exception {
    @Getter
    private String errorCode;

    public CacoAuth2Exception(String msg) {
        super(msg);
    }

    public CacoAuth2Exception(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}

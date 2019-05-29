/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：PlatformResult
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.result;

import io.uoko.caco.common.core.domain.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 平台通用返回结果
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformResult implements Result {
    private static final long serialVersionUID = 7471096505105106629L;
    private String code;

    private String msg;

    private Object data;

    public static PlatformResult success() {
        PlatformResult result = new PlatformResult();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static PlatformResult success(Object data) {
        PlatformResult result = new PlatformResult();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static PlatformResult failure(ResultCode resultCode) {
        PlatformResult result = new PlatformResult();
        result.setResultCode(resultCode);
        return result;
    }

    public static PlatformResult failure(ResultCode resultCode, Object data) {
        PlatformResult result = new PlatformResult();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static PlatformResult failure(String message) {
        PlatformResult result = new PlatformResult();
        result.setCode(ResultCode.PARAM_IS_INVALID.code());
        result.setMsg(message);
        return result;
    }

    public static PlatformResult failure(String code, String message) {
        PlatformResult result = new PlatformResult();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

}

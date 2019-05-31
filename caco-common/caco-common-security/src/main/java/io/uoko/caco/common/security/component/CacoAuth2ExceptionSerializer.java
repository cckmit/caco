/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：CacoAuth2ExceptionSerializer
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.uoko.caco.common.core.constant.CommonConstants;
import io.uoko.caco.common.security.exception.CacoAuth2Exception;
import lombok.SneakyThrows;

/**
 * <p>
 * 异常格式化
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
public class CacoAuth2ExceptionSerializer extends StdSerializer<CacoAuth2Exception> {
    public CacoAuth2ExceptionSerializer() {
        super(CacoAuth2Exception.class);
    }

    @Override
    @SneakyThrows
    public void serialize(CacoAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
        gen.writeStartObject();
        gen.writeObjectField("code", CommonConstants.FAIL);
        gen.writeStringField("msg", value.getMessage());
        gen.writeStringField("data", value.getErrorCode());
        gen.writeEndObject();
    }
}

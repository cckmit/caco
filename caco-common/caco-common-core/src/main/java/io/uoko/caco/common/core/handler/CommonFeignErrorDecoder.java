/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：CommonFeignErrorDecoder
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.handler;

import com.alibaba.fastjson.JSON;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.uoko.caco.common.core.exception.BusinessException;
import io.uoko.caco.common.core.result.DefaultErrorResult;
import io.uoko.caco.common.core.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Feign错误解码器类
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Component
@Slf4j
public class CommonFeignErrorDecoder extends ErrorDecoder.Default {
    private final Pattern pattern = Pattern.compile("[\t\r\n]");

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception defaultResultE = super.decode(methodKey, response);

        if (RetryableException.class.equals(defaultResultE.getClass())) {
            return defaultResultE;
        }

        log.error("远程服务全量错误信息:{}", defaultResultE.toString());
        String message = defaultResultE.getMessage();
        String separator = "content:";
        String content = StringUtils.substringAfterLast(message, separator);
        Matcher m = pattern.matcher(content);
        content = m.replaceAll("");
        DefaultErrorResult defaultResult = JSON.parseObject(content, DefaultErrorResult.class);
        if (defaultResult == null) {
            log.error("FeignErrorDecoder occurs error, defaultResult is null, response:{}", JsonUtils.object2Json(response));
            return defaultResultE;
        }

        if (defaultResult.getStatus() != null) {
            try {
                BusinessException businessException = (BusinessException) Class.forName(defaultResult.getException()).newInstance();
                businessException.setCode(defaultResult.getCode());
                businessException.setMessage(defaultResult.getMsg());
                businessException.setData(defaultResult.getErrors());
                return businessException;
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                log.error("请使用 BusinessException 统一抛出错误，架构组强行要求，谢谢配合");
                e.printStackTrace();
                BusinessException businessException = new BusinessException();
                businessException.setCode(defaultResult.getCode());
                businessException.setMessage(defaultResult.getMsg());
                businessException.setData(defaultResult.getErrors());
                return businessException;
            }
        } else {
            log.error("异常未捕获到，请检查抛出异常是否是BusinessException");
        }
        return defaultResultE;
    }
}

/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：ControllerAop
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.uoko.caco.common.core.constant.Constants;
import io.uoko.caco.common.core.util.IPUtils;
import io.uoko.caco.common.core.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Slf4j
@Aspect
@Component
public class ControllerAop {

    /**
     * 环绕通知
     *
     * @param joinPoint 连接点
     * @return 切入点返回值
     * @throws Throwable 异常信息
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController) ||" +
            "@annotation(org.springframework.web.bind.annotation.RestController)")
    public Object apiLog(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //2019/3/19 获取用户user对象，设置到UserUtil中
        String token = request.getHeader(Constants.REQ_HEADER);
        String userId = null;
        if (!StringUtils.isBlank(token) &&
                Constants.TOKEN_SPLIT.equals(token.substring(0, Constants.TOKEN_SPLIT.length()))) {
            userId = UserUtils.getUserId(request);
            if (userId != null) {
                UserUtils.setUser(userId);
            }
        }
        String ip = IPUtils.getRealIp(request);
        String methodName = this.getMethodName(joinPoint);
        String params = this.getParamsJson(joinPoint);
        String requester = userId == null ? "unknown" : userId;
        String path = request.getRequestURL().toString();

        log.info("Started request path [{}] requester [{}] method [{}] params [{}] IP [{}] token [{}] ", path, requester, methodName, params, ip, token);
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        UserUtils.clearAllUserInfo();
        log.info("Ended request requester [{}] method [{}] params[{}] response is [{}] cost [{}] millis ",
                requester, methodName, params, this.deleteSensitiveContent(result), System.currentTimeMillis() - start);
        return result;
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        String shortMethodNameSuffix = "(..)";
        if (methodName.endsWith(shortMethodNameSuffix)) {
            methodName = methodName.substring(0, methodName.length() - shortMethodNameSuffix.length());
        }
        return methodName;
    }

    private String getParamsJson(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            //移除敏感内容
            String paramStr;
            if (arg instanceof HttpServletResponse) {
                paramStr = HttpServletResponse.class.getSimpleName();
            } else if (arg instanceof HttpServletRequest) {
                paramStr = HttpServletRequest.class.getSimpleName();
            } else if (arg instanceof MultipartFile) {
                long size = ((MultipartFile) arg).getSize();
                paramStr = MultipartFile.class.getSimpleName() + " size:" + size;
            } else {
                paramStr = this.deleteSensitiveContent(arg);
            }
            sb.append(paramStr).append(",");
        }
        return sb.length() > 0 ? sb.deleteCharAt(sb.length() - 1).toString() : "not params";
    }

    /**
     * 删除参数中的敏感内容
     *
     * @param obj 参数对象
     * @return 去除敏感内容后的参数对象
     */
    private String deleteSensitiveContent(Object obj) {
        JSONObject jsonObject = new JSONObject();
        if (obj == null || obj instanceof Exception) {
            return jsonObject.toJSONString();
        }

        try {
            String param = JSON.toJSONString(obj);
            jsonObject = JSONObject.parseObject(param);
            List<String> sensitiveFieldList = this.getSensitiveFieldList();
            for (String sensitiveField : sensitiveFieldList) {
                if (jsonObject.containsKey(sensitiveField)) {
                    jsonObject.put(sensitiveField, "******");
                }
            }
        } catch (Exception e) {
            return String.valueOf(obj);
        }
        return jsonObject.toJSONString();
    }

    /**
     * 敏感字段列表
     */
    private List<String> getSensitiveFieldList() {
        List<String> sensitiveFieldList = Lists.newArrayList();
        sensitiveFieldList.add("pwd");
        sensitiveFieldList.add("password");
        return sensitiveFieldList;
    }

}

/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：AuthService
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.auth.biz.api.fegin;

import io.uoko.caco.auth.biz.api.domain.dto.TokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 授权接口
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
@FeignClient(name = "caco-auth")
public interface AuthService {


    /**
     * 获取/刷新 token接口
     *
     * @param authorization header标识客户端
     * @param parameters    请求参数
     * @return
     */
    @PostMapping("/oauth/token")
    TokenDTO postAccessToken(@RequestHeader("Authorization") String authorization,
                             @RequestParam Map<String, String> parameters);


    /**
     * 清除token,移除授权
     *
     * @param accessToken
     * @return
     */
    @DeleteMapping("token/token/{accessToken}")
    Boolean removeToken(@PathVariable("accessToken") String accessToken);
}

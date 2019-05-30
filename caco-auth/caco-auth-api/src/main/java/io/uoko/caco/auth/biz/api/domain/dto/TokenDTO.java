/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：TokenDTO
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/30
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.auth.biz.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * 授权结果信息
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/30
 */
@Data
@ToString
public class TokenDTO {
    /**
     * accessToken : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoiTUFERSBCWSBVT0tPIiwidXNlcl9uYW1lIjoiMTU4OTI0NDQ0NDQiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTQzODQ1MTE2LCJ1c2VySWQiOjUxMTYxOTQ1MDc2MzcxNDU2LCJhdXRob3JpdGllcyI6WyJBRE1JTl9VU0VSIiwiUk9MRV9VU0VSIl0sImp0aSI6ImUxMzA5NjFlLTZkYTAtNDE2YS04NTFlLWRmODRlODFkMTVmMiIsImNsaWVudF9pZCI6InVva28ifQ.rdb6KpXVgN2T3GrRYCrZUz85NbRjPg1DXPqr4_wYQ6A
     * tokenType : bearer
     * refreshToken : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoiTUFERSBCWSBVT0tPIiwidXNlcl9uYW1lIjoiMTU4OTI0NDQ0NDQiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiYXRpIjoiZTEzMDk2MWUtNmRhMC00MTZhLTg1MWUtZGY4NGU4MWQxNWYyIiwiZXhwIjoxNTQ2MzkzOTE2LCJ1c2VySWQiOjUxMTYxOTQ1MDc2MzcxNDU2LCJhdXRob3JpdGllcyI6WyJBRE1JTl9VU0VSIiwiUk9MRV9VU0VSIl0sImp0aSI6ImZkNWNlZTgyLWU1MTEtNDc5OC1iZDFkLTUwNTk5OTE1NjNkNiIsImNsaWVudF9pZCI6InVva28ifQ.RyxV9P4vGHVClr3wxcM4LRLey9itLpqpaVxhIweKV1Q
     * expiresIn : 32459
     * scope : server
     * license : MADE BY UOKO
     * userId : 51161945076371456
     * jti : e130961e-6da0-416a-851e-df84e81d15f2
     */

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private Long expiresIn;
    private String scope;
    private String license;
    private String userId;
    private String jti;
}

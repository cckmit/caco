/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：RoleVO
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.auth.domain.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *用户对应的角色
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Data
@ToString
public class RoleVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色code
     */
    private String roleCode;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private String deleted;
}

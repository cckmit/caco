///*
// * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
// * 项目名称：UOKO 系统
// * 类名称：SysGatewayRouteEntity
// * 创建人：绍华(for dingtalk)
// * 联系方式：uokoer@gmail.com
// * 创建时间：2019/5/24
// * 项目官网: https://uoko.io
// */
//package io.uoko.caco.gateway.domain.entity;
//
//import com.baomidou.mybatisplus.annotation.*;
//import lombok.Data;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
///**
// * <p>
// * 路由规则Entity
// * </p>
// *
// * @author uokoer
// * Email uokoer@gmail.com
// * Website https://uoko.io
// * created by 2019/5/24
// */
//@Data
//@TableName("sys_gateway_route")
//public class SysGatewayRouteEntity implements Serializable {
//    @TableId(value = "id", type = IdType.INPUT)
//    private String id;
//    /**
//     * 路由路径
//     */
//    private String path;
//    /**
//     * 服务名称
//     */
//    private String serviceId;
//    /**
//     * url代理
//     */
//    @TableField("url")
//    private String url;
//    /**
//     * 转发去掉前缀
//     */
//    private Integer stripPrefix;
//    /**
//     * 是否重试
//     */
//    private Integer retryAble;
//    /**
//     * 是否启用
//     */
//    private Integer enabled;
//    /**
//     * 敏感请求头
//     */
//    private String sensitiveHeadersList;
//
//    @TableLogic
//    @TableField("is_deleted")
//    private Integer deleted;
//    private LocalDateTime createTime;
//    private LocalDateTime updateTime;
//}

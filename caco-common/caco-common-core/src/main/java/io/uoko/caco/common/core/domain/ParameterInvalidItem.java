/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：ParameterInvalidItem
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.common.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 参数无效项
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParameterInvalidItem {

    /**
     * 无效字段的名称
     */
    private String fieldName;

    /**
     * 错误信息
     */
    private String message;

}

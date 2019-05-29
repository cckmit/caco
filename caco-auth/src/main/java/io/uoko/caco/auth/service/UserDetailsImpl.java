/*
 * Copyright (c) 2018-2019. uoko.io All Rights Reserved.
 * 项目名称：UOKO 系统
 * 类名称：UserDetailsImpl
 * 创建人：绍华(for dingtalk)
 * 联系方式：uokoer@gmail.com
 * 创建时间：2019/5/29
 * 项目官网: https://uoko.io
 */
package io.uoko.caco.auth.service;

import io.uoko.caco.auth.constant.SecurityConstants;
import io.uoko.caco.auth.domain.vo.RoleVO;
import io.uoko.caco.auth.domain.vo.UserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 生成token的user对象
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/29
 */
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String username;
    private String password;
    private Integer status;
    private List<RoleVO> roleList;

    public UserDetailsImpl(UserVo userVo) {
        this.userId = userVo.getUserId();
        this.username = userVo.getUsername();
        this.password = userVo.getPassword();
        this.status = userVo.getStatus();
        roleList = userVo.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        //遍历出role对应的角色
        for (RoleVO role : roleList) {
            authorityList.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }
        authorityList.add(new SimpleGrantedAuthority(SecurityConstants.BASE_ROLE));

        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !StringUtils.equals(SecurityConstants.STATUS_LOCK, String.valueOf(status));
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals(SecurityConstants.STATUS_NORMAL, String.valueOf(status));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

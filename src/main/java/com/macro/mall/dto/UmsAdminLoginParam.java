package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "Tên đăng nhập", required = true)
    @NotEmpty(message = "Tên người dùng không thể để trống")
    private String username;
    @ApiModelProperty(value = "Mật khẩu", required = true)
    @NotEmpty(message = "Mật khẩu không thể để trống")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

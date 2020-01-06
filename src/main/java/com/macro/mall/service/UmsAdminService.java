package com.macro.mall.service;

import com.macro.mall.mbg.model.UmsAdmin;
import com.macro.mall.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {
    /**
     * Nhận quản trị viên nền dựa trên tên người dùng
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * Chức năng đăng ký
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * Chức năng đăng nhập
     * @param username Tên đăng nhập
     * @param password Mật khẩu
     * @return Đã tạo mã thông báo JWT
     */
    String login(String username, String password);

    /**
     * Nhận tất cả các quyền của người dùng (bao gồm quyền vai trò và + - quyền)
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
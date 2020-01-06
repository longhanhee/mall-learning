package com.macro.mall.dto.mapper;

import com.macro.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminRoleRelationDao {

    /**
     * Nhận tất cả các quyền của người dùng (bao gồm + - quyền)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}

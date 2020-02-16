package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.UmsPermission;
import com.macro.mall.mbg.model.UmsPermissionExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsPermissionMapper extends TkMapper<UmsPermission> {
    long countByExample(UmsPermissionExample example);

    int deleteByExample(UmsPermissionExample example);

    List<UmsPermission> selectByExample(UmsPermissionExample example);

    int updateByExampleSelective(@Param("record") UmsPermission record, @Param("example") UmsPermissionExample example);

    int updateByExample(@Param("record") UmsPermission record, @Param("example") UmsPermissionExample example);
}
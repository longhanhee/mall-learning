package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.UmsRole;
import com.macro.mall.mbg.model.UmsRoleExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRoleMapper extends TkMapper<UmsRole> {
    long countByExample(UmsRoleExample example);

    int deleteByExample(UmsRoleExample example);

    List<UmsRole> selectByExample(UmsRoleExample example);

    int updateByExampleSelective(@Param("record") UmsRole record, @Param("example") UmsRoleExample example);

    int updateByExample(@Param("record") UmsRole record, @Param("example") UmsRoleExample example);
}
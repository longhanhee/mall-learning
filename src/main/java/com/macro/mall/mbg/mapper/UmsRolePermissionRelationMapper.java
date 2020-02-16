package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.UmsRolePermissionRelation;
import com.macro.mall.mbg.model.UmsRolePermissionRelationExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRolePermissionRelationMapper extends TkMapper<UmsRolePermissionRelation> {
    long countByExample(UmsRolePermissionRelationExample example);

    int deleteByExample(UmsRolePermissionRelationExample example);

    List<UmsRolePermissionRelation> selectByExample(UmsRolePermissionRelationExample example);

    int updateByExampleSelective(@Param("record") UmsRolePermissionRelation record, @Param("example") UmsRolePermissionRelationExample example);

    int updateByExample(@Param("record") UmsRolePermissionRelation record, @Param("example") UmsRolePermissionRelationExample example);
}
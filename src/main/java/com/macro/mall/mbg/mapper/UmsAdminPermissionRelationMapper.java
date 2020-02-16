package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.UmsAdminPermissionRelation;
import com.macro.mall.mbg.model.UmsAdminPermissionRelationExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminPermissionRelationMapper extends TkMapper<UmsAdminPermissionRelation> {
    long countByExample(UmsAdminPermissionRelationExample example);

    int deleteByExample(UmsAdminPermissionRelationExample example);

    List<UmsAdminPermissionRelation> selectByExample(UmsAdminPermissionRelationExample example);

    int updateByExampleSelective(@Param("record") UmsAdminPermissionRelation record, @Param("example") UmsAdminPermissionRelationExample example);

    int updateByExample(@Param("record") UmsAdminPermissionRelation record, @Param("example") UmsAdminPermissionRelationExample example);
}
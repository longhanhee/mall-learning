package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.UmsAdminRoleRelation;
import com.macro.mall.mbg.model.UmsAdminRoleRelationExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminRoleRelationMapper extends TkMapper<UmsAdminRoleRelation> {
    long countByExample(UmsAdminRoleRelationExample example);

    int deleteByExample(UmsAdminRoleRelationExample example);

    List<UmsAdminRoleRelation> selectByExample(UmsAdminRoleRelationExample example);

    int updateByExampleSelective(@Param("record") UmsAdminRoleRelation record, @Param("example") UmsAdminRoleRelationExample example);

    int updateByExample(@Param("record") UmsAdminRoleRelation record, @Param("example") UmsAdminRoleRelationExample example);
}
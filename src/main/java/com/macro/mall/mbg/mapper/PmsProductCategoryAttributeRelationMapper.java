package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.PmsProductCategoryAttributeRelation;
import com.macro.mall.mbg.model.PmsProductCategoryAttributeRelationExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductCategoryAttributeRelationMapper extends TkMapper<PmsProductCategoryAttributeRelation> {
    long countByExample(PmsProductCategoryAttributeRelationExample example);

    int deleteByExample(PmsProductCategoryAttributeRelationExample example);

    List<PmsProductCategoryAttributeRelation> selectByExample(PmsProductCategoryAttributeRelationExample example);

    int updateByExampleSelective(@Param("record") PmsProductCategoryAttributeRelation record, @Param("example") PmsProductCategoryAttributeRelationExample example);

    int updateByExample(@Param("record") PmsProductCategoryAttributeRelation record, @Param("example") PmsProductCategoryAttributeRelationExample example);
}
package com.macro.mall.dao;

import com.macro.mall.mbg.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductCategoryAttributeRelationDao {
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}

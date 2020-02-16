package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.PmsProductAttributeCategory;
import com.macro.mall.mbg.model.PmsProductAttributeCategoryExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductAttributeCategoryMapper extends TkMapper<PmsProductAttributeCategory> {
    long countByExample(PmsProductAttributeCategoryExample example);

    int deleteByExample(PmsProductAttributeCategoryExample example);

    List<PmsProductAttributeCategory> selectByExample(PmsProductAttributeCategoryExample example);

    int updateByExampleSelective(@Param("record") PmsProductAttributeCategory record, @Param("example") PmsProductAttributeCategoryExample example);

    int updateByExample(@Param("record") PmsProductAttributeCategory record, @Param("example") PmsProductAttributeCategoryExample example);
}
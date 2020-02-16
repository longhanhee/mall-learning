package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.PmsProductCategory;
import com.macro.mall.mbg.model.PmsProductCategoryExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductCategoryMapper extends TkMapper<PmsProductCategory> {
    long countByExample(PmsProductCategoryExample example);

    int deleteByExample(PmsProductCategoryExample example);

    List<PmsProductCategory> selectByExampleWithBLOBs(PmsProductCategoryExample example);

    List<PmsProductCategory> selectByExample(PmsProductCategoryExample example);

    int updateByExampleSelective(@Param("record") PmsProductCategory record, @Param("example") PmsProductCategoryExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProductCategory record, @Param("example") PmsProductCategoryExample example);

    int updateByExample(@Param("record") PmsProductCategory record, @Param("example") PmsProductCategoryExample example);
}
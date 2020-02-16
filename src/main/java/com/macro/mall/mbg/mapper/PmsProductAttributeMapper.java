package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.PmsProductAttribute;
import com.macro.mall.mbg.model.PmsProductAttributeExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductAttributeMapper extends TkMapper<PmsProductAttribute> {
    long countByExample(PmsProductAttributeExample example);

    int deleteByExample(PmsProductAttributeExample example);

    List<PmsProductAttribute> selectByExample(PmsProductAttributeExample example);

    int updateByExampleSelective(@Param("record") PmsProductAttribute record, @Param("example") PmsProductAttributeExample example);

    int updateByExample(@Param("record") PmsProductAttribute record, @Param("example") PmsProductAttributeExample example);
}
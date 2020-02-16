package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.PmsProduct;
import com.macro.mall.mbg.model.PmsProductExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductMapper extends TkMapper<PmsProduct> {
    long countByExample(PmsProductExample example);

    int deleteByExample(PmsProductExample example);

    List<PmsProduct> selectByExampleWithBLOBs(PmsProductExample example);

    List<PmsProduct> selectByExample(PmsProductExample example);

    int updateByExampleSelective(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);
}
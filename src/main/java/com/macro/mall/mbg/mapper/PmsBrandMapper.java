package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.PmsBrand;
import com.macro.mall.mbg.model.PmsBrandExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsBrandMapper extends TkMapper<PmsBrand> {
    long countByExample(PmsBrandExample example);

    int deleteByExample(PmsBrandExample example);

    List<PmsBrand> selectByExampleWithBLOBs(PmsBrandExample example);

    List<PmsBrand> selectByExample(PmsBrandExample example);

    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);
}
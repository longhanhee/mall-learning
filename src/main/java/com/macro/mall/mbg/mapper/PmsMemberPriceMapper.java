package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.PmsMemberPrice;
import com.macro.mall.mbg.model.PmsMemberPriceExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsMemberPriceMapper extends TkMapper<PmsMemberPrice> {
    long countByExample(PmsMemberPriceExample example);

    int deleteByExample(PmsMemberPriceExample example);

    List<PmsMemberPrice> selectByExample(PmsMemberPriceExample example);

    int updateByExampleSelective(@Param("record") PmsMemberPrice record, @Param("example") PmsMemberPriceExample example);

    int updateByExample(@Param("record") PmsMemberPrice record, @Param("example") PmsMemberPriceExample example);
}
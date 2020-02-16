package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.PmsProductVertifyRecord;
import com.macro.mall.mbg.model.PmsProductVertifyRecordExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductVertifyRecordMapper extends TkMapper<PmsProductVertifyRecord> {
    long countByExample(PmsProductVertifyRecordExample example);

    int deleteByExample(PmsProductVertifyRecordExample example);

    List<PmsProductVertifyRecord> selectByExample(PmsProductVertifyRecordExample example);

    int updateByExampleSelective(@Param("record") PmsProductVertifyRecord record, @Param("example") PmsProductVertifyRecordExample example);

    int updateByExample(@Param("record") PmsProductVertifyRecord record, @Param("example") PmsProductVertifyRecordExample example);
}
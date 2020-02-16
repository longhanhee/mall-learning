package com.macro.mall.mbg.mapper;

import com.macro.mall.mbg.model.UmsAdmin;
import com.macro.mall.mbg.model.UmsAdminExample;
import com.macro.mall.utils.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminMapper extends TkMapper<UmsAdmin> {
    long countByExample(UmsAdminExample example);

    int deleteByExample(UmsAdminExample example);

    List<UmsAdmin> selectByExample(UmsAdminExample example);

    int updateByExampleSelective(@Param("record") UmsAdmin record, @Param("example") UmsAdminExample example);

    int updateByExample(@Param("record") UmsAdmin record, @Param("example") UmsAdminExample example);
}
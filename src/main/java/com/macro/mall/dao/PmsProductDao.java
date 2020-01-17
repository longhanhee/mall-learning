package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;

public interface PmsProductDao {
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}

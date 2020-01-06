package com.macro.mall.dto.mapper;

import com.macro.mall.elasticsearch.model.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
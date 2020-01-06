package com.macro.mall.service;


import com.macro.mall.elasticsearch.model.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 商品搜索管理Service
 * Created by macro on 2018/6/19.
 */
public interface EsProductService {
    /**
     * Nhập tất cả các mục từ cơ sở dữ liệu vào ES
     */
    int importAll();

    /**
     * Xóa các mục dựa trên id
     */
    void delete(Long id);

    /**
     * Tạo sản phẩm dựa trên id
     */
    EsProduct create(Long id);

    /**
     * Xóa hàng loạt
     */
    void delete(List<Long> ids);

    /**
     * Tìm kiếm tên hoặc phụ đề dựa trên từ khóa
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
    Page<EsProduct> searchByName(String keyword, Integer pageNum, Integer pageSize);

}

package com.macro.mall.dto;

import com.macro.mall.mbg.model.PmsProductAttribute;
import com.macro.mall.mbg.model.PmsProductAttributeCategory;

import java.util.List;

public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    private List<PmsProductAttribute> productAttributeList;

    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<PmsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }
}

package com.macro.mall.dto;

import com.macro.mall.mbg.model.PmsMemberPrice;
import com.macro.mall.mbg.model.PmsProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PmsProductParam extends PmsProduct {
    @ApiModelProperty("商品会员价格设置")
    private List<PmsMemberPrice> memberPriceList;

    public List<PmsMemberPrice> getMemberPriceList() {
        return memberPriceList;
    }

    public void setMemberPriceList(List<PmsMemberPrice> memberPriceList) {
        this.memberPriceList = memberPriceList;
    }
}

package com.macro.mall.rabbitmq;

import lombok.Data;

@Data
public class OrderParam {
    //Địa chỉ nhận id
    private Long memberReceiveAddressId;
    //Id phiếu giảm giá
    private Long couponId;
    //Số điểm được sử dụng
    private Integer useIntegration;
    //支付方式
    private Integer payType;
}

package com.macro.mall.rabbitmq;

import com.macro.mall.common.api.CommonResult;
import org.springframework.transaction.annotation.Transactional;

public interface OmsPortalOrderService {

    /**
     * Tạo đơn hàng dựa trên thông tin gửi
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * Hủy đơn hàng hết thời gian
     */
    @Transactional
    void cancelOrder(Long orderId);
}

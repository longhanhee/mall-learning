package com.macro.mall.rabbitmq;

import lombok.Getter;


@Getter
public enum QueueEnum {
    /**
     * Hàng đợi thông báo tin nhắn
     */

    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    /**
     * Thông báo tin nhắn hàng đợi ttl
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    /**
     * Tên trao đổi
     */
    private String exchange;
    /**
     * Tên hàng đợi
     */
    private String name;
    /**
     * Phím định tuyến
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}

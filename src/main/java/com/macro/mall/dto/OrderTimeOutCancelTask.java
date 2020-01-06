package com.macro.mall.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * Quét cứ sau 10 phút, quét đơn hàng trước khi hết thời gian, hủy đơn hàng nếu không được thanh toán
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        // TODO: 2019/5/3 Ở đây bạn nên gọi phương thức hủy đơn hàng, xem cụ thể mã nguồn của dự án mall.
        LOGGER.info("Hủy đơn hàng và giải phóng kho khóa theo số sku");
    }
}

package com.macro.mall.rabbitmq;


import com.macro.mall.common.api.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        // todo thực hiện một loạt các hoạt động đặt hàng, tham khảo dự án trung tâm mua sắm
        LOGGER.info("process generateOrder");
        //Sau khi đơn hàng được hoàn thành, một thông báo chậm trễ được mở để hủy
        // đơn hàng khi người dùng không có khoản thanh toán (orderId sẽ được tạo
        // sau khi đơn hàng được đặt)
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null, "Đặt hàng thành công");
    }

    @Override
    public void cancelOrder(Long orderId) {
        //Todo thực hiện một loạt các đơn đặt hàng hủy, tham khảo dự án trung tâm mua sắm
        LOGGER.info("process cancelOrder orderId:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //Nhận thời gian chờ đơn hàng, được giả định là 60 phút (30 giây để thử nghiệm)
        long delayTimes = 5 * 1000;
        //Gửi tin nhắn bị trì hoãn
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

}

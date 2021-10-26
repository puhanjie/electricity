package com.puhj.electricity.service;

import com.puhj.electricity.dto.OrderDTO;
import com.puhj.electricity.logic.OrderChecker;
import com.puhj.electricity.model.Order;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface OrderService {
    Long placeOrder(Long uid, OrderDTO orderDTO, OrderChecker orderChecker);

    void sendToRedis(Long oid, Long uid, Long couponId);

    Page<Order> getUnpaid(Integer page, Integer size);

    Page<Order> getByStatus(Integer status, Integer page, Integer size);

    Optional<Order> getOrderDetail(Long oid);

    void updateOrderPrepayId(Long orderId, String prePayId);

    void writeOffCoupon(Long couponId, Long oid, Long uid);

    void reduceStock(OrderChecker orderChecker);

    OrderChecker isOk(Long uid, OrderDTO orderDTO);
}

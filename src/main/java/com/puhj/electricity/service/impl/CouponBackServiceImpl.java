package com.puhj.electricity.service.impl;

import com.puhj.electricity.bo.OrderMessageBO;
import com.puhj.electricity.core.enumeration.OrderStatus;
import com.puhj.electricity.exception.http.ServerErrorException;
import com.puhj.electricity.model.Order;
import com.puhj.electricity.repository.OrderRepository;
import com.puhj.electricity.repository.UserCouponRepository;
import com.puhj.electricity.service.CouponBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CouponBackServiceImpl implements CouponBackService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserCouponRepository userCouponRepository;

    @Transactional
    @Override
    public void returnBack(OrderMessageBO bo) {
        Long couponId = bo.getCouponId();
        Long uid = bo.getUserId();
        Long orderId = bo.getOrderId();

        if (couponId == -1) {
            return;
        }

        Optional<Order> optional = orderRepository.findFirstByUserIdAndId(uid, orderId);
        Order order = optional.orElseThrow(() ->new ServerErrorException(9999));

        if (order.getStatusEnum().equals(OrderStatus.UNPAID)
                || order.getStatusEnum().equals(OrderStatus.CANCELED)) {
            this.userCouponRepository.returnBack(couponId, uid);
        }
    }
}

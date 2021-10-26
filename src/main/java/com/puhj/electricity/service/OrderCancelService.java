package com.puhj.electricity.service;

import com.puhj.electricity.bo.OrderMessageBO;

public interface OrderCancelService {
    void cancel(OrderMessageBO messageBO);

    void cancel(Long oid);
}

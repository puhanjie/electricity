package com.puhj.electricity.service;

public interface WxPaymentNotifyService {
    void processPayNotify(String data);

    void deal(String orderNo);
}

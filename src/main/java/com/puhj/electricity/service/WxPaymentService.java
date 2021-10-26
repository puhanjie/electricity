package com.puhj.electricity.service;

import com.github.wxpay.sdk.WXPay;

import java.math.BigDecimal;
import java.util.Map;

public interface WxPaymentService {
    Map<String, String> preOrder(Long oid);

    Map<String, String> makePaySignature(Map<String, String> wxOrder);

    boolean unifiedOrderSuccess(Map<String, String> wxOrder);

    Map<String, String> makePreOrderParams(BigDecimal serverFinalPrice, String orderNo);

    WXPay assembleWxPayConfig();
}

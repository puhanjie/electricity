package com.puhj.electricity.service;

import com.puhj.electricity.model.Coupon;

import java.util.List;

public interface CouponService {
    List<Coupon> getByCategory(Long cid);

    List<Coupon> getWholeStoreCoupons();

    List<Coupon> getMyAvailableCoupons(Long uid);

    List<Coupon> getMyUsedCoupons(Long uid);

    List<Coupon> getMyExpiredCoupons(Long uid);

    void collectOneCoupon(Long uid, Long couponId);
}

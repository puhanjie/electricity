package com.puhj.electricity.service;

import com.puhj.electricity.model.Sku;

import java.util.List;

public interface SkuService {
    List<Sku> getSkuListByIds(List<Long> ids);
}

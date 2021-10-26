package com.puhj.electricity.service.impl;

import com.puhj.electricity.model.SaleExplain;
import com.puhj.electricity.repository.SaleExplainRepository;
import com.puhj.electricity.service.SaleExplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleExplainServiceImpl implements SaleExplainService {
    @Autowired
    private SaleExplainRepository saleExplainRepository;

    @Override
    public List<SaleExplain> getSaleExplainFixedList() {
        return this.saleExplainRepository.findByFixedOrderByIndex(true);
    }
}

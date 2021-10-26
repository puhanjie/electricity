package com.puhj.electricity.service.impl;

import com.puhj.electricity.model.Banner;
import com.puhj.electricity.repository.BannerRepository;
import com.puhj.electricity.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public Banner getByName(String name) {
        return this.bannerRepository.findOneByName(name);
    }
}

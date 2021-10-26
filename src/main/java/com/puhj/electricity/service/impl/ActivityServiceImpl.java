package com.puhj.electricity.service.impl;

import com.puhj.electricity.model.Activity;
import com.puhj.electricity.repository.ActivityRepository;
import com.puhj.electricity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity getByName(String name) {
        return activityRepository.findByName(name);
    }
}

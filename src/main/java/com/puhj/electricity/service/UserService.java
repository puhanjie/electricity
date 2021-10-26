package com.puhj.electricity.service;

import com.puhj.electricity.model.User;

import java.util.Map;

public interface UserService {
    User getUserById(Long id);

    void updateUserWxInfo(Map<String, Object> wxUser);

    User createDevUser(Long uid);

    User getUserByUnifyUid(Long uuid);
}

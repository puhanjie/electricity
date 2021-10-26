package com.puhj.electricity.service;

import java.util.Map;

public interface WxAuthenticationService {
    String code2Session(String code);

    String registerUser(Map<String, Object> session);
}

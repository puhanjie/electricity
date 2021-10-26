package com.puhj.electricity.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puhj.electricity.exception.http.ParameterException;
import com.puhj.electricity.model.User;
import com.puhj.electricity.repository.UserRepository;
import com.puhj.electricity.service.WxAuthenticationService;
import com.puhj.electricity.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WxAuthenticationServiceImpl implements WxAuthenticationService {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private UserRepository userRepository;
    @Value("${wx.code2session}")
    private String code2SessionUrl;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appsecret}")
    private String appsecret;

    @Override
    public String code2Session(String code) {
//        需要拿到小程序传进来的code去调用小程序的code2session地址获取到openid
        String url = MessageFormat.format(this.code2SessionUrl, this.appid, this.appsecret, code);
//        RestTemplate进行请求发送
        RestTemplate rest = new RestTemplate();
        Map<String, Object> session = new HashMap<>();
        String sessionText = rest.getForObject(url, String.class);
        try {
            session = mapper.readValue(sessionText, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.registerUser(session);
    }

    @Override
    public String registerUser(Map<String, Object> session) {
        String openid = (String)session.get("openid");
        if (openid == null){
            throw new ParameterException(20004);
        }
        Optional<User> userOptional = this.userRepository.findByOpenid(openid);
        if(userOptional.isPresent()){
            // TODO:返回JWT令牌
            // 数字等级
            return JwtToken.makeToken(userOptional.get().getId());
        }
//        未注册，先进行注册用户
        User user = User.builder().openid(openid).build();
        userRepository.save(user);
        // TODO:返回JWT令牌
        Long uid = user.getId();
        return JwtToken.makeToken(uid);
    }
}

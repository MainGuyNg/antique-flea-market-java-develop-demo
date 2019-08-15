package com.xunru.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WeChatAccessToken {
    private String accessToken;
    private int expiresIn;

}

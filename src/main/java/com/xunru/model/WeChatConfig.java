package com.xunru.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WeChatConfig {
    private String appid;
    private String appSecret;
    private String accesstokenurl;
    private String getUserinfourl;
}

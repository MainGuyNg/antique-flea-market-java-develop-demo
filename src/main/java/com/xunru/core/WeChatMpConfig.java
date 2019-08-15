package com.xunru.core;

import com.xunru.model.WeChatConfig;
import com.xunru.utils.WXAuthUtil;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WeChatMpConfig {

    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();

        //通过工具类获得一个WeChatConfig的实体类，里面从WeChatConfig.properties文件中获取并封装了公众平台的参数
        WeChatConfig weChatConfig = WXAuthUtil.getWeChatProperty();

        wxMpConfigStorage.setAppId(weChatConfig.getAppid());
        wxMpConfigStorage.setSecret(weChatConfig.getAppSecret());
        return wxMpConfigStorage;
    }
}

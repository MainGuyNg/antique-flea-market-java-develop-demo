package com.xunru.core.controller;


import com.xunru.core.model.AccessTokenConfig;
import com.xunru.model.WeChatAccessToken;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
public class WeChatController {

    private static final String RETURN_URL="mgtest2018.free.idcfengye.com";

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize() {
        String url = "http://mgtest2018.free.idcfengye.com/wechat/userInfo";
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(RETURN_URL));
        return "redirect:" + redirectURL;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) throws Exception {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        String openId = null;
        String accessToken = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            openId = wxMpOAuth2AccessToken.getOpenId();
            //本来应该用wxMpOAuth2AccessToken.getAccessToken()的，但是不知道为什么这个方法获取的access token很短，于是就换了个
            accessToken = wxMpService.getAccessToken();

            WeChatAccessToken weChatAccessToken = new WeChatAccessToken();

            weChatAccessToken.setAccessToken(accessToken);
            weChatAccessToken.setExpiresIn(wxMpOAuth2AccessToken.getExpiresIn());
            if (AccessTokenConfig.weChatAccessToken == null) {
                AccessTokenConfig.weChatAccessToken = weChatAccessToken;
            }
        } catch (WxErrorException e) {
            throw new Exception(e.getError().getErrorMsg());
        }
        String url = "http://" + returnUrl + "/user/login?openId=" + openId;
        return "redirect:" + url;
    }
}
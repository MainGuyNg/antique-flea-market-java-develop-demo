package com.xunru.utils;

public class ReplaceGetWeChatUserInfoUrlUtil {
    public static String replaceUrl(String url, String accessToken, String openId) {
        return url.replace("ACCESS_TOKEN",accessToken).replace("OPENID",openId);
    }
}

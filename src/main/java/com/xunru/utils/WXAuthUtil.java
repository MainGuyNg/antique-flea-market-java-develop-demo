package com.xunru.utils;

import com.alibaba.fastjson.JSON;
import com.xunru.model.User;
import com.xunru.model.WeChatConfig;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class WXAuthUtil {

    private static final String WECHAT_PROPERTIES_FILE_PATH = GetResource.class.getClassLoader().getResource("WeChatConfig.properties").getPath();

    public static WeChatConfig getWeChatProperty() {
        Properties properties = null;
        InputStream is = null;
        WeChatConfig wechatConfig = new WeChatConfig();

        try {
            is = new FileInputStream(new File(WECHAT_PROPERTIES_FILE_PATH));
            properties = new Properties();

            properties.load(is);

            String appid = properties.getProperty("wechat.appid");
            String appSecret = properties.getProperty("wechat.appsecret");
            String accessTokenUrl = properties.getProperty("wechat.accesstokenurl");

            //修改获取access token的网址
            accessTokenUrl = modifyAccessTokenUrl(accessTokenUrl, appid, appSecret);

            wechatConfig.setAppid(appid);
            wechatConfig.setAppSecret(appSecret);
            wechatConfig.setAccesstokenurl(accessTokenUrl);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wechatConfig;
    }

    public static String modifyAccessTokenUrl(String accessTokenUrl, String appid, String appSecret) {
        return accessTokenUrl.replace("APPID", appid).replace("SECRET", appSecret);
    }

    public static String modifyUserInfoUrl(String userInfoUrl, String openId, String accessToken) {
        return userInfoUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
    }

    public static User getUserInfo(String requestUrl) {
        InputStream is = null;
        BufferedReader bufr = null;
        User user = null;
        try {
            URL url = new URL(requestUrl);
            URLConnection connection = url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            is = connection.getInputStream();

            bufr = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = bufr.readLine()) != null) {
                user = JSON.parseObject(line, User.class);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (bufr != null) {
                    bufr.close();
                }
            } catch (IOException e) {

            }
        }
        return user;
    }

    public static String getToken(String openId) {
        String key = "XUNRU";
        Long date = System.currentTimeMillis();
        String[] arr = new String[]{key, date.toString(), openId};
        Arrays.sort(arr);
        StringBuilder builder = new StringBuilder();
        for (String str : arr) {
            builder.append(str);
        }
        return MD5Util.getMD5(builder.toString());
    }
}
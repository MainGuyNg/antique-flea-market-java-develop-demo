package com.xunru.controller;

import com.xunru.core.model.AccessTokenConfig;
import com.xunru.core.model.MvcObject;
import com.xunru.model.User;
import com.xunru.service.UserService;
import com.xunru.utils.ReplaceGetWechatUserInfoUrlUtil;
import com.xunru.utils.WXAuthUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    private static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    private static final int SESSION_VALID_TIME = 30 * 60;

    @RequestMapping("/login")
    @ResponseBody
    public MvcObject login(@RequestParam("openId") String openId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        MvcObject mvcObject = null;
        InputStream is = null;
        String requestUrl = null;
        User user = null;
        Map<String, Object> resultMap = new HashMap<>();

        if (AccessTokenConfig.weChatAccessToken != null) {
            //替换url地址中的参数
            String accessToken = AccessTokenConfig.weChatAccessToken.getAccessToken();
            requestUrl = ReplaceGetWechatUserInfoUrlUtil.replaceUrl(GET_USER_INFO_URL, accessToken, openId);
            //工具类通过requestUrl获取userInfo
            user = WXAuthUtil.getUserInfo(requestUrl);

            /*开始操作数据库*/
            User queryUser = userService.login(user);
            //当queryUser为空时执行注册操作，否则正常登录
            if (queryUser == null) {
                int result = userService.register(user);
                if (result == 0) {
                    mvcObject = new MvcObject(MvcObject.STATUS_500, MvcObject.getStatusDesc(MvcObject.STATUS_500));
                    throw new Exception();
                } else {
                    mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200));
                    //带着openId直接重定向回这个方法
                    response.sendRedirect("../user/login?openId=" + openId);
                }
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", queryUser);
                session.setMaxInactiveInterval(SESSION_VALID_TIME);
                resultMap.put("user", queryUser);
                resultMap.put("token", WXAuthUtil.getToken(openId));
                //当用户真实姓名或者所在公司填写为空时，跳转到相对应的资料填写页面
                if ("".equals(queryUser.getRealName()) || queryUser.getRealName() == null || "".equals(queryUser.getCompanyName()) || queryUser.getCompanyName() == null) {
                    mvcObject = new MvcObject(MvcObject.STATUS_505, "真实姓名或者所在公司没有数据，为第一次登陆", resultMap);
                } else {
                    mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200), resultMap);
                }
            }
        } else {
            System.out.println("access token为空或者access token非法，重新获取access token");
            //重定向到获取access token的方法
            response.sendRedirect("../wechat/authorize");
        }
        return mvcObject;
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public MvcObject updateUserInfo(User user, HttpServletRequest request) {
        MvcObject mvcObject = null;
        HttpSession session = request.getSession();
        if (user == null) {
            mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
        } else {
            int result = userService.updateUserInfo(user);
            if (result == 0) {
                mvcObject = new MvcObject(MvcObject.STATUS_500, MvcObject.getStatusDesc(MvcObject.STATUS_500));
            } else {
                //修改信息以后更新session域中的user信息
                session.setAttribute("user", userService.selectUserByPrimaryKey(user.getUserId()));
                mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200));
            }
        }
        return mvcObject;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}

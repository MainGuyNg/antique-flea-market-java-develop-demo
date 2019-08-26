package com.xunru.controller;

import com.xunru.core.model.MvcObject;
import com.xunru.model.Friend;
import com.xunru.model.User;
import com.xunru.service.FriendService;
import com.xunru.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/friend")
public class FriendController {
    @Resource
    FriendService friendService;
    @Resource
    UserService userService;

    @RequestMapping("/queryFriendListOrderByFriendRemark")
    @ResponseBody
    public MvcObject queryFriendListOrderByFriendRemark(HttpServletRequest request) {
        System.out.println("======queryFriendListOrderByFriendRemark======");

        MvcObject mvcObject = null;
        HttpSession session = request.getSession();
        Map<String, Object> resultMap = new HashMap<>();

        User requestUser = (User) session.getAttribute("user");
        if (requestUser == null) {
            mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
        } else {
            String userId = requestUser.getUserId();
            if (userId == null || "".equals(userId)) {
                mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
            } else {
                List<Friend> resultList = friendService.queryFriendListOrderByFriendRemark(userId);
                System.out.println("resultList.size==" + resultList.size());
                resultMap.put("friendList", resultList);
                mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200), resultMap);
            }
        }
        return mvcObject;
    }

    @RequestMapping("/queryFriendInfoByFriendId")
    @ResponseBody
    public MvcObject queryFriendInfoByFriendId(@RequestParam("friendId") String friendId, HttpServletRequest request) {
        MvcObject mvcObject = null;
        Map<String, Object> resultMap = new HashMap<>();
        if (friendId == null || "".equals(friendId)) {
            mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
        } else {
            User queryUser = userService.selectUserByPrimaryKey(friendId);
            if (queryUser == null) {
                mvcObject = new MvcObject(MvcObject.STATUS_500, MvcObject.getStatusDesc(MvcObject.STATUS_500));
            } else {
                resultMap.put("user", queryUser);
                mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200), resultMap);
            }
        }
        return mvcObject;
    }
}

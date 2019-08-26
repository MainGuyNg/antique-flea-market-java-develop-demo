package com.xunru.controller;

import com.xunru.core.model.MvcObject;
import com.xunru.model.FriendGroup;
import com.xunru.model.User;
import com.xunru.service.FriendGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/friendGroup")
public class FriendGroupController {

    @Resource
    FriendGroupService friendGroupService;

    @RequestMapping("/queryGroupList")
    @ResponseBody
    public MvcObject queryGroupList(HttpServletRequest request) {
        MvcObject mvcObject = null;
        HttpSession session = request.getSession();

        Map<String, Object> resultMap = new HashMap<>(16);
        User requestUser = (User) session.getAttribute("user");
        if (requestUser == null) {
            mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
        } else {
            String userId = requestUser.getUserId();
            if (userId == null || "".equals(userId)) {
                mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
            } else {
                List<FriendGroup> resultList = friendGroupService.queryFriendGroupByUserId(userId);
                if (resultList.size() == 0) {
                    mvcObject = new MvcObject(MvcObject.STATUS_500, MvcObject.getStatusDesc(MvcObject.STATUS_500));
                } else {
                    resultMap.put("friendGroupList", resultList);
                    mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200), resultMap);
                }
            }
        }
        return mvcObject;
    }

    @RequestMapping("/modifyFriendGroupInfo")
    @ResponseBody
    public MvcObject modifyFriendGroupInfo(FriendGroup friendGroup, HttpServletRequest request) {
        MvcObject mvcObject = null;
        if (friendGroup == null) {
            mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
        } else {
            int result = friendGroupService.modifyFriendGroupInfo(friendGroup);
            if (result == 0) {
                mvcObject = new MvcObject(MvcObject.STATUS_500, MvcObject.getStatusDesc(MvcObject.STATUS_500));
            } else {
                mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200));
            }
        }
        return mvcObject;
    }

    @RequestMapping("/addFriendGroup")
    @ResponseBody
    public MvcObject addFriendGroup(@RequestParam("groupName") String groupName, HttpServletRequest request) {
        MvcObject mvcObject = null;
        HttpSession session = request.getSession();
        User requestUser = (User) session.getAttribute("user");
        if (requestUser == null) {
            mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
        } else {
            String userId = requestUser.getUserId();
            if (userId == null || "".equals(userId) || groupName == null || "".equals(groupName)) {
                mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
            } else {
                int result = friendGroupService.addFriendGroup(userId, groupName);
                if (result == 0) {
                    mvcObject = new MvcObject(MvcObject.STATUS_500, MvcObject.getStatusDesc(MvcObject.STATUS_500));
                } else {
                    mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200));
                }
            }
        }
        return mvcObject;
    }

    @RequestMapping("/deleteFriendGroup")
    @ResponseBody
    public MvcObject deleteFriendGroup(@RequestParam("groupId") String groupId, HttpServletRequest request) {
        MvcObject mvcObject = null;
        HttpSession session = request.getSession();
        User requestUser = (User) session.getAttribute("user");
        if (requestUser == null) {
            mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
        } else {
            String userId = requestUser.getUserId();
            if (userId == null || "".equals(userId) || groupId == null || "".equals(groupId)) {
                mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
            } else {
                int result = friendGroupService.deleteFriendGroup(userId, groupId);
                if (result == 0) {
                    mvcObject = new MvcObject(MvcObject.STATUS_500, MvcObject.getStatusDesc(MvcObject.STATUS_500));
                } else {
                    mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200));
                }
            }
        }
        return mvcObject;
    }

}

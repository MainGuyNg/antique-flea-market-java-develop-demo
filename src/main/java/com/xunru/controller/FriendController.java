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
                List<Friend> resultList = friendService.queryFriendListByUserIdOrderByFriendRemark(userId);
                System.out.println("resultList.size==" + resultList.size());
                resultMap.put("friendList", resultList);
                mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200), resultMap);
            }
        }
        return mvcObject;
    }

    @RequestMapping("/addFriend")
    public MvcObject addFriend(@RequestParam("friendId") String friendId, String friendRemark, HttpServletRequest request) {
        MvcObject mvcObject = null;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if (user == null) {
            mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
        } else {
            String userId = user.getUserId();
            //检查friendId和userId是否为空
            if (friendId == null || "".equals(friendId) || userId == null || "".equals(userId)) {
                mvcObject = new MvcObject(MvcObject.STATUS_505, MvcObject.getStatusDesc(MvcObject.STATUS_505));
            } else {
                //检查是否已经添加好友，如果查询出来的对象不为空，则表示已经是好友
                Friend friend = friendService.queryFriendInfoByUserIdAndFriendId(userId,friendId);
                if (friend!=null){
                    mvcObject = new MvcObject(MvcObject.STATUS_200,"已经是好友");
                }else {
                    //如果没填写备注，这里将会用目标用户的昵称作为备注填进去
                    if (friendRemark == null || "".equals(friendRemark)) {
                        User queryUser = userService.selectUserByPrimaryKey(friendId);
                        if (queryUser != null) {
                            friendRemark = queryUser.getNickname();
                        }
                    }
                    int result = friendService.addFriend(userId, friendId, friendRemark);
                    if (result == 0) {
                        mvcObject = new MvcObject(MvcObject.STATUS_500, MvcObject.getStatusDesc(MvcObject.STATUS_500));
                    } else {
                        mvcObject = new MvcObject(MvcObject.STATUS_200, MvcObject.getStatusDesc(MvcObject.STATUS_200));
                    }
                }
            }
        }
        return mvcObject;
    }

}

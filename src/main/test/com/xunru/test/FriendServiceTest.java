package com.xunru.test;

import com.xunru.model.Friend;
import com.xunru.model.User;
import com.xunru.service.FriendService;
import com.xunru.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class FriendServiceTest extends BaseTest {

    @Resource
    FriendService friendService;
    @Resource
    UserService userService;

    @Test
    public void test() {
        List<Friend> list = friendService.queryFriendListByUserIdOrderByFriendRemark("4f35acaf89d0425eb7185fb29cedfda1");
        System.out.println("=========================================");
        for (Friend f : list) {
            System.out.println(f.getFriendRemark());
            System.out.println();
        }
        System.out.println("=========================================");

    }

    @Test
    public void test2(){
        User user = userService.selectUserByPrimaryKey("4f35acaf89d0425eb7185fb29cedfda1");
        System.out.println(user.toString());
    }
}

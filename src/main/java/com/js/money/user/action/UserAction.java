package com.js.money.user.action;

import com.js.money.user.entity.User;
import com.js.money.user.service.IUserService;
import com.js.money.util.BaseResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserAction {
    @Resource
    private IUserService userService;
    @RequestMapping("/addUser")
    public BaseResponse addUser(@RequestBody User user) {
        userService.saveUser(user);
        return new BaseResponse();
    }

    @RequestMapping("/getAllUser")
    public BaseResponse getAllUser() {
        List<User> userList = userService.getAllUser();
        return new BaseResponse(userList);
    }
}

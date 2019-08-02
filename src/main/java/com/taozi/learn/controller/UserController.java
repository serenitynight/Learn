package com.taozi.learn.controller;

import com.taozi.learn.pojo.User;
import com.taozi.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author ：zhangwei
 * @date ：2019/8/2 11:31
 * @description：用户信息Controller
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 查询所有用户
    @RequestMapping(value = "/queryAllUsers", method = RequestMethod.GET)
    public ArrayList<User> queryAllUsers() {
        return userService.queryAllUsers();
    }

}

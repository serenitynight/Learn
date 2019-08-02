package com.taozi.learn.service;

import com.taozi.learn.mapper.UserMapper;
import com.taozi.learn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author ：zhangwei
 * @date ：2019/8/2 11:43
 * @description：用户信息Service
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    // 查询所有数据
    public ArrayList<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }
}

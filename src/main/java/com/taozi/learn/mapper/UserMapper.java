package com.taozi.learn.mapper;

import com.taozi.learn.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author ：zhangwei
 * @date ：2019/8/2 11:43
 * @description：用户信息Mapper
 */
@Repository
public interface UserMapper {

    // 查询所有数据
    ArrayList<User> queryAllUsers();
}

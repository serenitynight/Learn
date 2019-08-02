package com.taozi.learn.pojo;

/**
 * @author ：zhangwei
 * @date ：2019/8/2 11:44
 * @description：用户信息实体类
 */
public class User {
    private Long id;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}

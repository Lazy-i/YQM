package com.lazyi.service;

import com.lazyi.pojo.User;

import java.util.List;

public interface UserService extends Service{
    List<User> addUser(User user) throws Exception;
}

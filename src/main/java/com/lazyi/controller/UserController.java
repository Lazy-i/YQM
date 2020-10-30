package com.lazyi.controller;

import com.lazyi.mapper.UserMapper;
import com.lazyi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/api/queryUserList", method = RequestMethod.GET)
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for(User user : userList){
            System.out.println(user);
        }

        return userList;
    }

    @RequestMapping(value = "/api/addUser", method = RequestMethod.GET)
    public String addUser(User user){
        userMapper.addUser(user);
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(User user){
        userMapper.updateUser(user);
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(-1);
        return "ok";
    }
}

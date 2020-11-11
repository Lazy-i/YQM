package com.lazyi.controller;

import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.mapper.UserMapper;
import com.lazyi.pojo.User;
import com.lazyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

/*
    @RequestMapping(value = "/api/queryUserList", method = RequestMethod.GET)
    public ResultBean queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for(User user : userList){
            System.out.println(user);
        }

        return ExceptionCatch.exceptionCatch(userService);
    }
*/


    @RequestMapping(value = "/api/addUser", method = RequestMethod.GET)
    public ResultBean addUser(@RequestParam(value = "userName", required = true) String userName,
                              @RequestParam(value = "userAccount", required = true) String userAccount,
                              @RequestParam(value = "userPassword", required = true) String userPassword){
       return ExceptionCatch.exceptionCatch(userService, userAccount, userName, userAccount, userPassword);
    }

    @RequestMapping(value = "/api/queryUserById", method = RequestMethod.GET)
    public ResultBean queryUserById(@RequestParam(value = "userId", required = true) Integer userId){
        return ExceptionCatch.exceptionCatch(userService, userId.toString(),userId);
    }

    @RequestMapping(value = "/api/queryUserByUserAccount", method = RequestMethod.GET)
    public ResultBean queryUserByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount){
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount);
    }

    @RequestMapping(value = "/api/updateUserPassword", method = RequestMethod.GET)
    public ResultBean updateUserPassword(@RequestParam(value = "userAccount", required = true) String userAccount,
                                         @RequestParam(value = "userOldPassword",required = true) String userOldPassword,
                                         @RequestParam(value = "userNewPassword",required = true) String userNewPassword){
//        userMapper.updateUser(user);
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userOldPassword, userNewPassword);
    }
/*
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(-1);
        return "ok";
    }*/

    @RequestMapping(value = "/api/login", method = RequestMethod.GET)
    public ResultBean login(@RequestParam(value = "userAccount", required = true) String userAccount,
                            @RequestParam(value = "userPassword", required = true) String userPassword) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userPassword);
    }

    @RequestMapping(value = "/api/logout", method = RequestMethod.GET)
    public ResultBean userLogout(@RequestParam(value = "userAccount", required = true) String userAccount,
                                 @RequestParam(value = "userPassword", required = true) String userPassword) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userPassword);
    }


}

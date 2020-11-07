package com.lazyi.service;

import com.lazyi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService extends Service{

    List<User> queryUserById(Integer id) throws Exception;

    List<User> queryUserByUserAccount(String userAccount) throws Exception;

    List<User> addUser(String userName, String userAccount,String userPassword) throws Exception;

    List<User> updateUser(String userAccount,String userOldPassword, String userNewPassword) throws Exception;

    List<User> deleteUser(Integer id) throws Exception;

    List<User> login(String userAccount, String userPassword) throws Exception;

    List<User> userLogout(String userAccount, String userPassword) throws Exception;



}

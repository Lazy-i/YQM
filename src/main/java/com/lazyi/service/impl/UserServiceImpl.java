package com.lazyi.service.impl;

import com.lazyi.mapper.UserMapper;
import com.lazyi.pojo.User;
import com.lazyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> addUser(String userName, String userAccount, String userPassword) throws Exception {

        if(userMapper.isDuplicate(userAccount) == 1) throw new Exception("Duplicate-userAccount");
        int userId = userMapper.getPrimayKey() + 1;
        userMapper.addUser(userId,userName, userAccount, userPassword);
        return queryUserByUserAccount(userAccount);
    }

    @Override
    public List<User> queryUserById(Integer id) throws Exception {
        List<User> users = userMapper.queryUserById(id);
        if(users.size() == 0) throw new Exception("UserId not Exist in DB");
        return users;
    }

    @Override
    public List<User> queryUserByUserAccount(String userAccount) throws Exception {
        List<User> users = userMapper.queryUserByUserAccount(userAccount);
        if(users.size() == 0) throw new Exception("UserId not Exist in DB");
        return users;
    }

    @Override
    public List<User> updateUser(String userAccount, String userOldPassword, String userNewPassword) throws Exception {
        List<User> users = login(userAccount, userOldPassword);
        userMapper.updateUser(userAccount, userOldPassword, userNewPassword);
        return queryUserByUserAccount(userAccount);
    }

    @Override
    public List<User> deleteUser(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<User> login(String userAccount, String userPassword) throws Exception {
        List<User> userByUserAccount = queryUserByUserAccount(userAccount);
        if(userByUserAccount.get(0).getUserPassword().equals(userPassword)){

            return userByUserAccount;
        }
        else{
            throw new Exception("Wrong password or Account");
        }

    }

    @Override
    public List<User> userLogout(String userAccount, String userPassword) throws Exception {
        List<User> users = login(userAccount, userPassword);
        userMapper.userLogout(userAccount,userPassword);
        return users;
    }

}



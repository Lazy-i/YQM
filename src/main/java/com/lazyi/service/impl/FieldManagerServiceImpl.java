package com.lazyi.service.impl;

import com.lazyi.mapper.FieldManagerMapper;
import com.lazyi.mapper.UserMapper;
import com.lazyi.pojo.FieldManager;
import com.lazyi.pojo.User;
import com.lazyi.service.FieldManagerService;
import com.lazyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FieldManagerServiceImpl implements FieldManagerService {

    @Autowired
    private FieldManagerMapper fieldManagerMapper;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<FieldManager> queryFieldManagerById(Integer id) throws Exception {
        List<FieldManager> fieldManagers = fieldManagerMapper.queryFieldManagerById(id);
        if(fieldManagers.size() == 0) throw new Exception("FieldManagerId is not in DB !");
        return fieldManagers;
    }

    @Override
    public List<FieldManager> queryFieldManagerByUserAccount(String userAccount) throws Exception {
        List<FieldManager> fieldManagers = fieldManagerMapper.queryFieldManagerByUserAccount(userAccount);
        if(fieldManagers.size() == 0) throw new Exception("FieldManagerId is not in DB !");
        return fieldManagers;
    }

    @Override
    public List<FieldManager> addFieldManager(String name, Integer telephoneNumber, String userAccount, String userPassword) throws Exception {
        int fieldManagerId = fieldManagerMapper.getPrimayKey(userAccount, userPassword);
        userMapper.updateUserIsF(userAccount, userPassword, fieldManagerId);
        fieldManagerMapper.addFieldManager(fieldManagerId, name, telephoneNumber);
        return queryFieldManagerById(fieldManagerId);
    }

    @Override
    public List<FieldManager> updateFieldManager(String name, Integer telephoneNumber, String userAccount, String userPassword) throws Exception {
        List<User> users = userService.login(userAccount, userPassword);
        fieldManagerMapper.updateFieldManager(name, telephoneNumber, userAccount, userPassword);
        return fieldManagerMapper.queryFieldManagerByUserAccount(userAccount);
    }

    @Override
    public List<User> deleteFieldManager(String userAccount, String userPassword) throws Exception {
        List<User> users =userService.login(userAccount, userPassword);
        fieldManagerMapper.deleteFieldManager(userAccount, userPassword);
        return userMapper.queryUserByUserAccount(userAccount);
    }
}

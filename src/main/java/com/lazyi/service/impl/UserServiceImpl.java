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


}

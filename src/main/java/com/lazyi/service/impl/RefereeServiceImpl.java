package com.lazyi.service.impl;

import com.lazyi.mapper.RefereeMapper;
import com.lazyi.mapper.UserMapper;
import com.lazyi.pojo.Referee;
import com.lazyi.pojo.User;
import com.lazyi.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RefereeServiceImpl implements RefereeService {

    @Autowired
    private RefereeMapper refereeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Referee> queryRefereeById(Integer id) throws Exception {
        List<Referee> referees = refereeMapper.queryRefereeById(id);
        if(referees.size() == 0) throw new Exception("RefereeId is not in DB !");
        return referees;
    }

    @Override
    public List<Referee> queryRefereeByUserAccount(String userAccount) throws Exception {
        List<Referee> referees = refereeMapper.queryRefereeByUserAccount(userAccount);
        if(referees.size() == 0) throw new Exception("RefereeId is not in DB !");
        return referees;
    }

    @Override
    public List<Referee> addReferee(String name, Integer telephoneNumber, String refereeNumber, String userAccount, String userPassword) throws Exception {
        int refereeId = refereeMapper.getPrimayKey() + 1;
        userMapper.updateUserIsR(userAccount, userPassword, refereeId);
        refereeMapper.addReferee(refereeId, name, telephoneNumber, refereeNumber);
        return queryRefereeById(refereeId);
    }

    @Override
    public List<Referee> updateReferee(String name, Integer telephoneNumber, String refereeNumber, Integer isWorking, String userAccount, String userPassword) throws Exception {
        List<User> users = userService.login(userAccount, userPassword);
        refereeMapper.updateReferee(name, telephoneNumber, refereeNumber, isWorking,userAccount, userPassword);
        return refereeMapper.queryRefereeByUserAccount(userAccount);
    }

    @Override
    public List<User> deleteReferee(String userAccount, String userPassword) throws Exception {
        List<User> users = userService.login(userAccount, userPassword);
        refereeMapper.deleteReferee(userAccount,userPassword);
        return userMapper.queryUserByUserAccount(userAccount);
    }
}

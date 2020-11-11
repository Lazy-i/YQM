package com.lazyi.service.impl;

import com.lazyi.mapper.PlayerMapper;
import com.lazyi.mapper.UserMapper;
import com.lazyi.pojo.Player;
import com.lazyi.pojo.User;
import com.lazyi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Player> queryPlayerById(Integer id) throws Exception {
        List<Player> players = playerMapper.queryPlayerById(id);
        if(players.size() == 0) throw new Exception("PlayerId not Exist in DB");
        return players;
    }

    @Override
    public List<Player> queryPlayerByUserAccount(String userAccount) throws Exception {
        List<Player> players = playerMapper.queryPlayerByUserAccount(userAccount);
        if(players.size() == 0) throw new Exception("PlayerId not Exist in DB");
        return players;
    }

    @Override
    public List<Player> addPlayer(String name, Integer telephoneNumber, Integer emergencyContactNumber, String userAccount, String userPassword) throws Exception {
        int playerId = playerMapper.getPrimayKey() + 1;
        userMapper.updateUserIsP(userAccount,userPassword,playerId);
        playerMapper.addPlayer(playerId, name, telephoneNumber, emergencyContactNumber);
        return queryPlayerById(playerId);
    }

    @Override
    public List<Player> updatePlayer(String name, Integer telephoneNumber, Integer emergencyContactNumber, Integer isCaptain,String userAccount, String userPassword) throws Exception {
        List<User> users = userService.login(userAccount, userPassword);
        playerMapper.updatePlayer(name, userAccount, userPassword, telephoneNumber, emergencyContactNumber, isCaptain);
        return playerMapper.queryPlayerByUserAccount(userAccount);
    }

    @Override
    public List<User> deletePlayer(String userAccount, String userPassword) throws Exception {
        List<User> users = userService.login(userAccount, userPassword);
        playerMapper.deletePlayer(userAccount, userPassword);
        return userMapper.queryUserByUserAccount(userAccount);
    }
}

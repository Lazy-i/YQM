package com.lazyi.service;

import com.lazyi.pojo.Player;
import com.lazyi.pojo.User;
import com.lazyi.service.Service;

import java.util.List;

public interface PlayerService extends Service {
    List<Player> queryPlayerById(Integer id) throws Exception;

    List<Player> queryPlayerByUserAccount(String userAccount) throws Exception;

    List<Player> addPlayer(String name, Integer telephoneNumber,Integer emergencyContactNumber, String userAccount, String userPassword) throws Exception;

    List<Player> updatePlayer(String name, Integer telephoneNumber,Integer emergencyContactNumber, Integer isCaptain,String userAccount, String userPassword) throws Exception;

    List<User> deletePlayer(String userAccount, String userPassword) throws Exception;

}



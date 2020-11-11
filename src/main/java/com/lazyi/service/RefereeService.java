package com.lazyi.service;

import com.lazyi.pojo.Player;
import com.lazyi.pojo.Referee;
import com.lazyi.pojo.User;

import java.util.List;

public interface RefereeService extends Service{
    List<Referee> queryRefereeById(Integer id) throws Exception;

    List<Referee> queryRefereeByUserAccount(String userAccount) throws Exception;

    List<Referee> addReferee(String name, Integer telephoneNumber,String refereeNumber, String userAccount, String userPassword) throws Exception;

    List<Referee> updateReferee(String name, Integer telephoneNumber,String refereeNumber, Integer isWorking, String userAccount, String userPassword) throws Exception;

    List<User> deleteReferee(String userAccount, String userPassword) throws Exception;
}

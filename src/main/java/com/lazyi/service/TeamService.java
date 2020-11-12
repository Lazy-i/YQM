package com.lazyi.service;


import com.lazyi.pojo.Team;

import java.util.List;

public interface TeamService extends Service {

    List<Team> queryTeamById(Integer id) throws Exception;

    List<Team> queryTeamByCaptainId(Integer captainId) throws Exception;

    List<Team> addTeam(String teamName, Integer captainId, Integer captainTelephoneNumber) throws Exception;

    List<Team> updateTeam(String teamName, Integer captainId, Integer captainTelephoneNumber,Integer teamId) throws Exception;

    List<Team> deleteTeam(Integer teamId, String userAccount, String userPassword) throws Exception;

}

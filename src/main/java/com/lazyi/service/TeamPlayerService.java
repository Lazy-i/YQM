package com.lazyi.service;

import com.lazyi.pojo.TeamPlayer;

import java.util.List;

public interface TeamPlayerService extends Service{

    List<TeamPlayer> queryTeamPlayerById(Integer playerId, Integer teamId) throws Exception;

    List<TeamPlayer> queryTeamAllPlayerById(Integer teamId) throws Exception;

    List<TeamPlayer> queryPlayerAllTeamById(Integer playerId) throws Exception;

    List<TeamPlayer> isCaptainById(Integer playerId, Integer teamId) throws Exception;

    List<TeamPlayer> teamAddPlayer(Integer playerId, Integer teamId) throws Exception;

    List<TeamPlayer> playerAddTeam(Integer playerId, Integer teamId) throws Exception;

    List<TeamPlayer> updateIsAddPlayer(Integer isAddPlayer, Integer playerId, Integer teamId) throws Exception;

    List<TeamPlayer> updateIsCameMatch(Integer isCameMatch, Integer playerId, Integer teamId) throws Exception;

    List<TeamPlayer> updateIsCameEnrol(Integer isCameEnrol, Integer playerId, Integer teamId) throws Exception;

    List<TeamPlayer> deleteTeamPlayer(Integer playerId, Integer teamId, Integer isCaptain) throws Exception;

}

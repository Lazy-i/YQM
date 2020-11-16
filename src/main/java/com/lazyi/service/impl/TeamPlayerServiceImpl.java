package com.lazyi.service.impl;

import com.lazyi.mapper.TeamPlayerMapper;
import com.lazyi.pojo.TeamPlayer;
import com.lazyi.service.TeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TeamPlayerServiceImpl implements TeamPlayerService {

    @Autowired
    private TeamPlayerMapper teamPlayerMapper;

    @Override
    public List<TeamPlayer> queryTeamPlayerById(Integer playerId, Integer teamId) throws Exception {
        List<TeamPlayer> teamPlayers = teamPlayerMapper.queryTeamPlayerById(playerId,teamId);
        if(teamPlayers.size() == 0) throw new Exception("Wrong PlayerId OR TeamId !");
        return teamPlayers;
    }

    @Override
    public List<TeamPlayer> queryTeamAllPlayerById(Integer teamId) throws Exception {
        List<TeamPlayer> teamPlayers = teamPlayerMapper.queryTeamAllPlayerById(teamId);
        if(teamPlayers.size() == 0) throw new Exception("teamId IS NOT IN DB !");
        return teamPlayers;
    }

    @Override
    public List<TeamPlayer> queryPlayerAllTeamById(Integer playerId) throws Exception {
        List<TeamPlayer> teamPlayers = teamPlayerMapper.queryPlayerAllTeamById(playerId);
        if(teamPlayers.size() == 0) throw new Exception("playerId IS NOT IN DB !");
        return teamPlayers;
    }

    @Override
    public List<TeamPlayer> isCaptainById(Integer playerId, Integer teamId) throws Exception {
        return null;
    }

    @Override
    public List<TeamPlayer> teamAddPlayer(Integer playerId, Integer teamId) throws Exception {
        List<TeamPlayer> teamPlayers = teamPlayerMapper.queryTeamPlayerById(playerId,teamId);
        if(teamPlayers.size() == 1) throw new Exception("This TeamPlayer is already in DB !");
        teamPlayerMapper.teamAddPlayer(playerId, teamId);
        return queryTeamPlayerById(playerId, teamId);
    }

    @Override
    public List<TeamPlayer> playerAddTeam(Integer playerId, Integer teamId) throws Exception {
        teamPlayerMapper.playerAddTeam(playerId, teamId);
        return queryTeamPlayerById(playerId, teamId);
    }

    @Override
    public List<TeamPlayer> updateIsAddPlayer(Integer isAddPlayer, Integer playerId, Integer teamId) throws Exception {
        teamPlayerMapper.updateIsAddPlayer(playerId, teamId, isAddPlayer);
        return queryTeamPlayerById(playerId, teamId);
    }

    @Override
    public List<TeamPlayer> updateIsCameMatch(Integer isCameMatch, Integer playerId, Integer teamId) throws Exception {
        teamPlayerMapper.updateIsCameMatch(playerId, teamId, isCameMatch);
        return queryTeamPlayerById(playerId, teamId);
    }

    @Override
    public List<TeamPlayer> updateIsCameEnrol(Integer isCameEnrol, Integer playerId, Integer teamId) throws Exception {
        teamPlayerMapper.updateIsCameEnrol(playerId, teamId, isCameEnrol);
        return queryTeamPlayerById(playerId, teamId);
    }

    @Override
    public List<TeamPlayer> deleteTeamPlayer(Integer playerId, Integer teamId, Integer isCaptain) throws Exception {
        if(isCaptain == 0){
            teamPlayerMapper.deletePlayer(playerId, teamId);
        }else{
            teamPlayerMapper.deleteTeam(teamId);
        }
        return teamPlayerMapper.queryPlayerAllTeamById(playerId);
    }
}

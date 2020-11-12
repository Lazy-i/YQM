package com.lazyi.service.impl;

import com.lazyi.mapper.PlayerMapper;
import com.lazyi.mapper.TeamMapper;
import com.lazyi.mapper.UserMapper;
import com.lazyi.pojo.Player;
import com.lazyi.pojo.Team;
import com.lazyi.pojo.User;
import com.lazyi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private PlayerMapper playerMapper;


    @Override
    public List<Team> queryTeamById(Integer id) throws Exception {
        List<Team> teams = teamMapper.queryTeamById(id);
        if(teams.size() == 0) throw new Exception("teamID IS NOT IN DB !");
        return teams;
    }

    @Override
    public List<Team> queryTeamByCaptainId(Integer captainId) throws Exception {
        List<Team> teams = teamMapper.queryTeamByCaptainId(captainId);
        if(teams.size() == 0) throw new Exception("teamID IS NOT IN DB !");
        return teams;
    }

    @Override
    public List<Team> addTeam(String teamName, Integer captainId, Integer captainTelephoneNumber) throws Exception {
        int teamId = teamMapper.getPrimayKey() + 1;
        teamMapper.addTeam(teamId,teamName,captainId, captainTelephoneNumber);
        playerMapper.updatePlayerIsC(captainId, teamId);
        return queryTeamById(teamId);
    }

    @Override
    public List<Team> updateTeam(String teamName, Integer captainId, Integer captainTelephoneNumber, Integer teamId) throws Exception {
        teamMapper.updateTeam(teamName,captainId,captainTelephoneNumber,teamId);
        return queryTeamById(teamId);
    }

    @Override
    public List<Team> deleteTeam(Integer teamId, String userAccount, String userPassword) throws Exception {

        return null;
    }
}

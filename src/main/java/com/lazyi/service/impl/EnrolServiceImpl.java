package com.lazyi.service.impl;

import com.lazyi.mapper.*;
import com.lazyi.pojo.*;
import com.lazyi.service.EnrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EnrolServiceImpl implements EnrolService {

    @Autowired
    private EnrolMapper enrolMapper;

    @Autowired
    private EnPlayerMapper enPlayerMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private TeamPlayerMapper teamPlayerMapper;

    @Override
    public List<Enrol> queryEnrolList() throws Exception {
        List<Enrol> enrols = enrolMapper.queryEnrolList();
        if(enrols.size() == 0) throw new Exception(" No Enrol In DB");
        return enrols;
    }

    @Override
    public List<Enrol> queryEnrolByTeamId(Integer teamId) throws Exception {
        List<Enrol> enrols = enrolMapper.queryEnrolByTeamId(teamId);
        if(enrols.size() == 0) throw new Exception(" No Enrol In DB");
        return enrols;
    }

    @Override
    public List<Enrol> queryEnrolByPlayerId(Integer playerId) throws Exception {
        List<TeamPlayer> teamPlayers = teamPlayerMapper.queryPlayerAllTeamById(playerId);
        List<Enrol> enrols = new ArrayList<>();
        for(TeamPlayer teamPlayer : teamPlayers) {
            enrols.addAll(enrolMapper.queryEnrolByTeamId(teamPlayer.getTeamId()));
        }
        if(enrols.size() == 0) throw new Exception(" No Enrol In DB");
        return enrols;
    }

    @Override
    public List<Enrol> queryEnrolByEnId(Integer enId) throws Exception {
        List<Enrol> enrols = enrolMapper.queryEnrolByEnId(enId);
        if(enrols.size() == 0) throw new Exception(" No Enrol In DB");
        return enrols;
    }

    @Override
    public List<Enrol> addEnrol(Integer teamId, String teamName, Integer teamNum, String fieldName, Integer isNeedReferee, String time) throws Exception {
        int id = enrolMapper.getPrimayKey() + 1;
        enrolMapper.addEnrol(id, teamId, teamName, teamNum, fieldName , isNeedReferee, time, 1, 0);
        return enrolMapper.queryEnrolByEnId(id);
    }

    @Override
    public List<Enrol> updateEnrol(Integer enId, Integer teamNum, String fieldName, Integer isNeedReferee, String time, Integer goPlayerNum, Integer isShowing) throws Exception {
        enrolMapper.updateEnrol(enId,  teamNum, fieldName, isNeedReferee, time, goPlayerNum, isShowing);
        return enrolMapper.queryEnrolByEnId(enId);
    }

    @Override
    public List<Enrol> attendEnrol(Integer enId, Integer playerId) throws Exception {
        List<EnPlayer> enPlayers = enPlayerMapper.queryEnPlayerByEnId(enId);
        int i = 0;
        try{ enPlayerMapper.addEnPlayer(enId, playerId);

        }catch (Exception e){
            for(EnPlayer enPlayer : enPlayers){
                if(playerId == enPlayer.getPlayerId()){
                    throw new Exception("YOU HAVE ALREADY ENROL !");
                }
            }
        }
        return queryEnrolByEnId(enId);
    }

    @Override
    public List<Enrol> queryEnrolAllShow() throws Exception {
        List<Enrol> enrols = enrolMapper.queryEnrolAllShow();
        if(enrols.size() == 0) throw new Exception(" No Enrol In DB");
        return enrols;
    }

    @Override
    public List<Enrol> showEnrol(Integer enId, Integer isShowing) throws Exception {
        enrolMapper.showEnrol(enId, isShowing);
        return queryEnrolByEnId(enId);
    }

    @Override
    public void deleteEnrol(Integer enId) throws Exception {
        enrolMapper.deleteEnrol(enId);
    }

    @Override
    public List<Player> queryPlayerTelNumberByTeamId(Integer teamId) throws Exception {
        List<Team> teams = teamMapper.queryTeamById(teamId);
        List<Player> players = playerMapper.queryPlayerById(teams.get(0).getCaptainId());
        return players;
    }
}

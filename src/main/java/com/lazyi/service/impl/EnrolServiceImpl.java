package com.lazyi.service.impl;

import com.lazyi.mapper.EnPlayerMapper;
import com.lazyi.mapper.EnrolMapper;
import com.lazyi.pojo.Enrol;
import com.lazyi.service.EnrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnrolServiceImpl implements EnrolService {

    @Autowired
    private EnrolMapper enrolMapper;

    @Autowired
    private EnPlayerMapper enPlayerMapper;

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
        enPlayerMapper.addEnPlayer(enId, playerId);
        enrolMapper.attendEnrol(enId);
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
}

package com.lazyi.service;


import com.lazyi.pojo.Enrol;

import java.util.List;

public interface EnrolService extends Service {

    List<Enrol> queryEnrolList() throws Exception;

    List<Enrol> queryEnrolByTeamId(Integer teamId) throws Exception;

    List<Enrol> queryEnrolByEnId(Integer enId) throws Exception;

    List<Enrol> addEnrol(Integer teamId, String teamName, Integer teamNum, String fieldName, Integer isNeedReferee, String time) throws Exception;

    List<Enrol> updateEnrol(Integer enId, Integer teamNum, String fieldName, Integer isNeedReferee, String time, Integer goPlayerNum, Integer isShowing) throws Exception;

    List<Enrol> attendEnrol(Integer enId, Integer playerId) throws Exception;

    List<Enrol> queryEnrolAllShow() throws Exception;

    List<Enrol> showEnrol(Integer enId,Integer isShowing) throws Exception;

    void deleteEnrol(Integer enId) throws Exception;
}

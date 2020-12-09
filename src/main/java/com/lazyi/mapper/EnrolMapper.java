package com.lazyi.mapper;

import com.lazyi.pojo.Enrol;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnrolMapper {

    @ResultType(Integer.class)
    Integer getPrimayKey();

    List<Enrol> queryEnrolList();

    List<Enrol> queryEnrolByTeamId(Integer teamId);

    List<Enrol> queryEnrolByEnId(Integer enId);

    void addEnrol(Integer enId, Integer teamId, String teamName, Integer teamNum, String fieldName, Integer isNeedReferee, String time, Integer goPlayerNum, Integer isShowing);

    void updateEnrol(Integer enId, Integer teamNum, String fieldName, Integer isNeedReferee, String time, Integer goPlayerNum, Integer isShowing);

    void attendEnrol(Integer enId);

    List<Enrol> queryEnrolAllShow();

    void showEnrol(Integer enId,Integer isShowing);

    void deleteEnrol(Integer enId);

}

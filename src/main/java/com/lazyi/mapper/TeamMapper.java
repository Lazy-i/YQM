package com.lazyi.mapper;

import com.lazyi.pojo.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamMapper {

    @ResultType(Integer.class)
    Integer getPrimayKey();

    List<Team> queryTeamById(@Param("teamId") Integer teamId);

    List<Team> queryTeamByCaptainId(@Param("captainId") Integer captainId);

    void addTeam(@Param("teamId") Integer teamId,
                 @Param("teamName") String teamName,
                 @Param("captainId") Integer captainId,
                 @Param("captainTelephoneNumber") Integer captainTelephoneNumber);

    void updateTeam(@Param("teamName")String teamName,
                    @Param("captainId") Integer captainId,
                    @Param("captainTelephoneNumber") Integer captainTelephoneNumber,
                    @Param("teamId") Integer teamId);

    void deleteTeam(@Param("teamId") Integer teamId,
                    @Param("userAccount") String userAccount,
                    @Param("userPassword") String userPassword);
}

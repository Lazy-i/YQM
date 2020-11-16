package com.lazyi.mapper;

import com.lazyi.pojo.TeamPlayer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamPlayerMapper {

    List<TeamPlayer> queryTeamPlayerById(@Param("playerId") Integer playerId,
                                         @Param("teamId") Integer teamId);

    List<TeamPlayer> queryTeamAllPlayerById(@Param("teamId") Integer teamId);

    List<TeamPlayer> queryPlayerAllTeamById(@Param("playerId") Integer playerId);

    List<TeamPlayer> isCaptainByID(@Param("playerId") Integer playerId,
                                   @Param("teamId") Integer teamId);

    void teamAddPlayer(@Param("playerId") Integer playerId,
                       @Param("teamId") Integer teamId);

    void playerAddTeam(@Param("playerId") Integer playerId,
                       @Param("teamId") Integer teamId);

    void updateIsAddPlayer(@Param("playerId") Integer playerId,
                           @Param("teamId") Integer teamId,
                           @Param("isAddPlayer") Integer isAddPlayer);

    void updateIsCameMatch(@Param("playerId") Integer playerId,
                           @Param("teamId") Integer teamId,
                           @Param("isCameMatch")Integer isCameMatch);

    void updateIsCameEnrol(@Param("playerId") Integer playerId,
                           @Param("teamId") Integer teamId,
                           @Param("isCameEnrol") Integer isCameEnrol);

    void deletePlayer(@Param("playerId") Integer playerId,
                      @Param("teamId") Integer teamId);

    void deleteTeam(@Param("teamId") Integer teamId);
}

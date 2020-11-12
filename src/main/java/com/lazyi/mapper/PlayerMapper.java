package com.lazyi.mapper;

import com.lazyi.pojo.Player;
import com.lazyi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlayerMapper {

    @ResultType(Integer.class)
    Integer getPrimayKey(@Param("userAccount") String userAccount,
                         @Param("userPassword") String userPassword);

    @ResultType(Integer.class)
    List<Player> queryPlayerById(@Param("playerId") Integer id);

    List<Player> queryPlayerByUserAccount(@Param("userAccount") String userAccount);

    void addPlayer(@Param("playerId") int playerId,
                   @Param("name") String name,
                   @Param("telephoneNumber") int telephoneNumber,
                   @Param("emergencyContactNumber") int emergencyContactNumber);

    void updatePlayer(@Param("name") String name,
                      @Param("userAccount") String userAccount,
                      @Param("userPassword") String userPassword,
                      @Param("telephoneNumber") int telephoneNumber,
                      @Param("emergencyContactNumber") int emergencyContactNumber,
                      @Param("isCaptain") int isCaptain);

    void  deletePlayer(@Param("userAccount") String userAccount,
                       @Param("userPassword") String userNewPassword);

    void updatePlayerIsC(@Param("playerId") Integer playerId,
                         @Param("isCaptain") Integer isCaptain);
}

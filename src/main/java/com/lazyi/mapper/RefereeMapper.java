package com.lazyi.mapper;

import com.lazyi.pojo.Player;
import com.lazyi.pojo.Referee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RefereeMapper {

    @ResultType(Integer.class)
    Integer getPrimayKey(@Param("userAccount") String userAccount,
                         @Param("userPassword") String userPassword);

    @ResultType(Integer.class)
    List<Referee> queryRefereeById(@Param("refereeId") Integer id);

    List<Referee> queryRefereeByUserAccount(@Param("userAccount")String userAccount);

    void addReferee(@Param("refereeId") Integer refereeId,
                    @Param("name") String name,
                    @Param("telephoneNumber") Integer telephoneNumber,
                    @Param("refereeNumber") String refereeNumber);

    void updateReferee(@Param("name") String name,
                       @Param("telephoneNumber") Integer telephoneNumber,
                       @Param("refereeNumber") String refereeNumber,
                       @Param("isWorking") Integer isWorking,
                       @Param("userAccount") String userAccount,
                       @Param("userPassword") String userPassword);

    void deleteReferee(@Param("userAccount")String userAccount,
                       @Param("userPassword")String userPassword);
}

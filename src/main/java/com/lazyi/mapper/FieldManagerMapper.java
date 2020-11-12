package com.lazyi.mapper;

import com.lazyi.pojo.FieldManager;
import com.lazyi.pojo.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FieldManagerMapper {

    @ResultType(Integer.class)
    Integer getPrimayKey(@Param("userAccount") String userAccount,
                         @Param("userPassword") String userPassword);

    @ResultType(Integer.class)
    List<FieldManager> queryFieldManagerById(@Param("fieldManagerId") Integer FieldManagerId);

    List<FieldManager> queryFieldManagerByUserAccount(@Param("userAccount") String userAccount);

    void addFieldManager(@Param("fieldManagerId") Integer FieldManagerId,
                         @Param("name") String name,
                         @Param("telephoneNumber") Integer telephoneNumber);

    void updateFieldManager(@Param("name") String name,
                            @Param("telephoneNumber") Integer telephoneNumber,
                            @Param("userAccount") String userAccount,
                            @Param("userPassword") String userPassword);

    void deleteFieldManager(@Param("userAccount") String userAccount,
                            @Param("userPassword") String userPassword);
}

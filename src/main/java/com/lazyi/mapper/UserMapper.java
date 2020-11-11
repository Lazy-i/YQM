package com.lazyi.mapper;


import com.lazyi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {


/*    @Results({
            @Result(property = "userId",column = "userId"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "userAccount", column = "userAccount"),
            @Result(property = "userPassword", column = "userPassword"),
            @Result(property = "isPlayer",column = "isPlayer"),
            @Result(property = "isReferee", column = "isReferee"),
            @Result(property = "isFieldManager", column = "isFieldManager")
    })*/


 //   List<User> queryUserList();

    @ResultType(Integer.class)
    Integer getPrimayKey();

    @ResultType(Integer.class)
    List<User> queryUserById(@Param("userId") Integer id);

    @ResultType(Integer.class)
    int isPasswordRight(@Param("userAccount") String userAccount, @Param("userOldPassword") String userOldPassword);

    List<User> queryUserByUserAccount(@Param("userAccount") String userAccount);

    void addUser(@Param("userId") int userId,
                 @Param("userName") String userName,
                 @Param("userAccount") String userAccount,
                 @Param("userPassword") String userPassword);

    void updateUserPassword(@Param("userAccount") String userAccount,
                            @Param("userNewPassword")String userNewPassword);

//    List<User> deleteUser(@Param("userId")Integer userId);

    List<User> login(@Param("userAccount") String userAccount,
                     @Param("userPassword") String userPassword);

    List<User> userLogout(@Param("userAccount") String userAccount,
                          @Param("userPassword") String userPassword);

    @ResultType(Integer.class)
    int isDuplicate(@Param("userAccount") String userAccount);

    void updateUser(@Param("userAccount")String userAccount,
                    @Param("userPassword")String userPassword,
                    @Param("isPlayer")int isPlayer,
                    @Param("isReferee")int isReferee,
                    @Param("isFieldManager")int isFieldManager);

    void updateUserIsP(@Param("userAccount")String userAccount,
                       @Param("userPassword")String userPassword,
                       @Param("isPlayer")int isPlayer);

    void updateUserIsR(@Param("userAccount")String userAccount,
                       @Param("userPassword")String userPassword,
                       @Param("isReferee")int isReferee);

    void updateUserIsF(@Param("userAccount")String userAccount,
                       @Param("userPassword")String userPassword,
                       @Param("isFieldManager")int isFieldManager);

}


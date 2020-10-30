package com.lazyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private int isPlayer;
    private int isReferee;
    private int isFieldManager;
}

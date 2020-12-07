package com.lazyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrol {
    private int enId;
    private int teamId;
    private String teamName;
    private int playerNum;
    private String fieldName;
    private int isNeedReferee;
    private String time;
    private int goPlayerNum;
    private int isShowing;
}

package com.lazyi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamPlayer {

    private int playerId;
    private int teamId;
    private int isCaptain;
    private int isAddPlayer;
    private int isCameMatch;
    private int isCameEnrol;
}

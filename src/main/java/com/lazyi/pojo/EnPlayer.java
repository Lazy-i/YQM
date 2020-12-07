package com.lazyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnPlayer {

    private int matchId;
    private int enId;
    private int playerId;
    private String playerName;
}

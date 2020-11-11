package com.lazyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private int playerId;
    private String name;
    private int telephoneNumber;
    private int emergencyContactNumber;
    private int isCaptain;
}

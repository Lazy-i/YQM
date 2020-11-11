package com.lazyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Referee {
    private int refereeId;
    private String name;
    private int telephoneNumber;
    private String refereeNumber;
    private int isWorking;
}

package com.lazyi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    private int fieldId;
    private String fieldName;
    private String fieldSpace;
    private String openTime;
    private int fieldState;
    private int fieldManagerId;
}

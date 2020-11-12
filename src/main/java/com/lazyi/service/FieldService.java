package com.lazyi.service;

import com.lazyi.pojo.Field;

import java.util.List;

public interface FieldService extends Service{

    List<Field> queryFieldById(Integer id) throws Exception;

    List<Field> queryFieldByFieldManagerId(Integer fieldManagerId) throws Exception;

    List<Field> addField(String fieldName, String fieldSpace, String openTime, Integer fieldManagerId) throws Exception;

    List<Field> updateField(String fieldName, String fieldSpace, String openTime, Integer fieldState, Integer fieldManagerId, Integer fieldId) throws Exception;

    List<Field> deleteField(String userAccount, String userPassword, String fieldId) throws Exception;
}

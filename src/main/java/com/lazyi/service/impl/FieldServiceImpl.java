package com.lazyi.service.impl;

import com.lazyi.mapper.FieldMapper;
import com.lazyi.pojo.Field;
import com.lazyi.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldMapper fieldMapper;


    @Override
    public List<Field> queryFieldById(Integer id) throws Exception {
        List<Field> fields = fieldMapper.queryFieldById(id);
        if(fields.size() == 0) throw new Exception("FieldID IS NOT IN DB !");
        return fields;
    }

    @Override
    public List<Field> queryFieldByFieldManagerId(Integer fieldManagerId) throws Exception {
        List<Field> fields = fieldMapper.queryFieldByFieldManagerId(fieldManagerId);
        if(fields.size() == 0) throw new Exception("FieldDID IS NOT IN DB !");
        return fields;
    }

    @Override
    public List<Field> addField(String fieldName, String fieldSpace, String openTime, Integer fieldManagerId) throws Exception {
        int fieldId = fieldMapper.getPrimayKey() + 1;
        fieldMapper.addField(fieldId, fieldName, fieldSpace, openTime, fieldManagerId);
        return queryFieldById(fieldId);
    }

    @Override
    public List<Field> updateField(String fieldName, String fieldSpace, String openTime, Integer fieldState, Integer fieldManagerId, Integer fieldId) throws Exception {
        fieldMapper.updateField(fieldName, fieldSpace, openTime, fieldState, fieldManagerId,fieldId);
        return queryFieldById(fieldId);
    }

    @Override
    public List<Field> deleteField(String userAccount, String userPassword, String fieldId) throws Exception {
        return null;
    }
}

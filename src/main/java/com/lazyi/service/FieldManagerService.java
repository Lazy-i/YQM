package com.lazyi.service;

import com.lazyi.pojo.FieldManager;
import com.lazyi.pojo.User;

import java.util.List;

public interface FieldManagerService extends Service{

    List<FieldManager> queryFieldManagerById(Integer id) throws Exception;

    List<FieldManager> queryFieldManagerByUserAccount(String userAccount) throws Exception;

    List<FieldManager> addFieldManager(String name, Integer telephoneNumber, String userAccount, String userPassword) throws Exception;

    List<FieldManager> updateFieldManager(String name, Integer telephoneNumber, String userAccount, String userPassword) throws  Exception;

    List<User> deleteFieldManager(String userAccount, String userPassword) throws Exception;
}

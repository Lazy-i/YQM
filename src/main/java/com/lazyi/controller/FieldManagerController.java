package com.lazyi.controller;

import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.service.FieldManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldManagerController {

    @Autowired
    private FieldManagerService fieldManagerService;

    @RequestMapping(value = "/api/queryFieldManagerById", method = RequestMethod.GET)
    public ResultBean queryFieldManagerById(@RequestParam(value = "fieldManagerId", required = true) Integer fieldManagerId){
        return ExceptionCatch.exceptionCatch(fieldManagerService, fieldManagerId.toString(), fieldManagerId);
    }

    @RequestMapping(value = "/api/queryFieldManagerByUserAccount", method = RequestMethod.GET)
    public ResultBean queryFieldManagerByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount){
        return ExceptionCatch.exceptionCatch(fieldManagerService, userAccount, userAccount);
    }

   @RequestMapping(value = "/api/addFieldManager", method = RequestMethod.GET)
   public ResultBean addFieldManager(@RequestParam(value = "name", required = true) String name,
                                     @RequestParam(value = "telephoneNumber", required = true) Integer telephoneNumber,
                                     @RequestParam(value = "userAccount", required = true) String userAccount,
                                     @RequestParam(value = "userPassword", required = true) String userPassword){
        return ExceptionCatch.exceptionCatch(fieldManagerService, userAccount, name, telephoneNumber,userAccount,userPassword);
   }

   @RequestMapping(value = "/api/updateFieldManager", method = RequestMethod.GET)
   public ResultBean updateFieldManager(@RequestParam(value = "name", required = true) String name,
                                        @RequestParam(value = "telephoneNumber", required = true) Integer telephoneNumber,
                                        @RequestParam(value = "userAccount", required = true) String userAccount,
                                        @RequestParam(value = "userPassword", required = true) String userPassword){
       return ExceptionCatch.exceptionCatch(fieldManagerService, userAccount, name, telephoneNumber, userAccount, userPassword);
   }

   @RequestMapping(value = "/api/deleteFieldManager", method = RequestMethod.GET)
    public ResultBean deleteFieldManager(@RequestParam(value = "userAccount", required = true) String userAccount,
                                         @RequestParam(value =  "userPassword", required = true) String userPassword){
        return ExceptionCatch.exceptionCatch(fieldManagerService, userAccount, userAccount, userPassword);
   }
}

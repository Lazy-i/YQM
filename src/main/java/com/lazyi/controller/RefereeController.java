package com.lazyi.controller;

import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefereeController {

    @Autowired
    private RefereeService refereeService;

    @RequestMapping(value = "/api/queryRefereeById",method = RequestMethod.GET)
    public ResultBean queryRefereeById(@RequestParam(value = "refereeId", required = true) Integer refereeId){
        return ExceptionCatch.exceptionCatch(refereeService,refereeId.toString(),refereeId);
    }

    @RequestMapping(value = "/api/queryRefereeByUserAccount", method = RequestMethod.GET)
    public ResultBean queryRefereeByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount){
        return ExceptionCatch.exceptionCatch(refereeService,userAccount, userAccount);
    }

    @RequestMapping(value = "/api/addReferee", method = RequestMethod.GET)
    public ResultBean addReferee(@RequestParam(value = "name", required = true) String name,
                                 @RequestParam(value = "telephoneNumber", required = true) Integer telephoneNumber,
                                 @RequestParam(value = "refereeNumber", required = true) String refereeNumber,
                                 @RequestParam(value = "userAccount", required = true) String userAccount,
                                 @RequestParam(value = "userPassword", required = true) String userPassword){
        return ExceptionCatch.exceptionCatch(refereeService, userAccount, name, telephoneNumber, refereeNumber, userAccount, userPassword);
    }

    @RequestMapping(value = "/api/updateReferee", method = RequestMethod.GET)
    public ResultBean updateReferee(@RequestParam(value = "name", required = true)String name,
                                    @RequestParam(value = "telephoneNumber", required = true)Integer telephoneNumber,
                                    @RequestParam(value = "refereeNumber",required = true)String refereeNumber,
                                    @RequestParam(value = "isWorking", required = true)Integer isWorking,
                                    @RequestParam(value = "userAccount", required = true)String userAccount,
                                    @RequestParam(value = "userPassword", required = true)String userPassword){
        return ExceptionCatch.exceptionCatch(refereeService, userAccount, name, telephoneNumber,refereeNumber, isWorking, userAccount, userPassword);
    }

    @RequestMapping(value = "/api/deleteReferee", method = RequestMethod.GET)
    public ResultBean deleteReferee(@RequestParam(value = "userAccount", required = true) String userAccount,
                                    @RequestParam(value = "userPassword", required = true) String userPassword){
        return ExceptionCatch.exceptionCatch(refereeService, userAccount, userAccount, userPassword);
    }
}

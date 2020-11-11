package com.lazyi.controller;


import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/api/queryPlayerById", method = RequestMethod.GET)
    public ResultBean queryPlayerById(@RequestParam(value = "playerId", required = true)Integer playerId){
        return ExceptionCatch.exceptionCatch(playerService,playerId.toString(),playerId);
    }

    @RequestMapping(value = "/api/queryPlayerByUserAccount", method = RequestMethod.GET)
    public ResultBean queryPlayerByUserAccount(@RequestParam(value= "userAccount", required = true)String userAccount){
        return ExceptionCatch.exceptionCatch(playerService,userAccount,userAccount);
    }

    @RequestMapping(value = "/api/addPlayer", method = RequestMethod.GET)
    public ResultBean addPlayer(@RequestParam(value = "name", required = true)String name,
                                @RequestParam(value = "telephoneNumber", required = true)int telephoneNumber,
                                @RequestParam(value = "emergencyContactNumber", required = true)int emergencyContactNumber,
                                @RequestParam(value = "userAccount", required = true)String userAccount,
                                @RequestParam(value = "userPassword", required = true)String userPassword){
        return ExceptionCatch.exceptionCatch(playerService,userAccount,name,telephoneNumber,emergencyContactNumber,userAccount,userPassword);
    }

    @RequestMapping(value = "/api/updatePlayer", method = RequestMethod.GET)
    public ResultBean updatePlayer(@RequestParam(value = "name", required = true)String name,
                                   @RequestParam(value = "telephoneNumber", required = true)int telephoneNumber,
                                   @RequestParam(value = "emergencyContactNumber",required = true)int emergencyContactNumber,
                                   @RequestParam(value = "isCaptain", required = true)int isCaptain,
                                   @RequestParam(value = "userAccount", required = true)String userAccount,
                                   @RequestParam(value = "userPassword", required = true)String userPassword){
        return ExceptionCatch.exceptionCatch(playerService, userAccount, name, telephoneNumber, emergencyContactNumber, isCaptain, userAccount, userPassword);
    }

    @RequestMapping(value = "/api/deletePlayer", method = RequestMethod.GET)
    public ResultBean deletePlayer(@RequestParam(value = "userAccount", required = true) String userAccount,
                                   @RequestParam(value = "userPassword", required = true) String userPassword){
        return ExceptionCatch.exceptionCatch(playerService, userAccount, userAccount, userPassword);
    }
}

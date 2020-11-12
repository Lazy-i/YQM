package com.lazyi.controller;

import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/api/queryTeamById", method = RequestMethod.GET)
    public ResultBean queryTeamById(@RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamService, teamId.toString(), teamId);
    }

    @RequestMapping(value = "/api/queryTeamByCaptainId", method = RequestMethod.GET)
    public ResultBean queryTeamByCaptainId(@RequestParam(value = "captainId", required = true) Integer captainId){
        return ExceptionCatch.exceptionCatch(teamService, captainId.toString(), captainId);
    }

    @RequestMapping(value = "/api/addTeam", method = RequestMethod.GET)
    public ResultBean addTeam(@RequestParam(value = "teamName", required = true) String teamName,
                              @RequestParam(value = "captainId", required = true) Integer captainId,
                              @RequestParam(value = "captainTelephoneNumber", required = true) Integer captainTelephoneNumber){
        return ExceptionCatch.exceptionCatch(teamService,captainId.toString(), teamName, captainId, captainTelephoneNumber);
    }

    @RequestMapping(value = "/api/updateTeam", method = RequestMethod.GET)
    public ResultBean updateTeam(@RequestParam(value = "teamName", required = true) String teamName,
                                 @RequestParam(value = "captainId", required = true) Integer captainId,
                                 @RequestParam(value = "captainTelephoneNumber", required = true) Integer captainTelephoneNumber,
                                 @RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamService,captainId.toString(), teamName, captainId, captainTelephoneNumber,teamId);
    }
}

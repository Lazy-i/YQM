package com.lazyi.controller;

import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.service.TeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamPlayerController {

    @Autowired
    private TeamPlayerService teamPlayerService;

    @RequestMapping(value = "/api/queryTeamPlayerById", method = RequestMethod.GET)
    public ResultBean queryTeamPlayerById(@RequestParam(value = "playerId", required = true) Integer playerId,
                                          @RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamPlayerService, playerId.toString(), playerId, teamId);
    }

    @RequestMapping(value = "/api/queryTeamAllPlayerById", method = RequestMethod.GET)
    public ResultBean queryTeamAllPlayerById(@RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamPlayerService,teamId.toString(), teamId);
    }

    @RequestMapping(value = "/api/queryPlayerAllTeamById", method = RequestMethod.GET)
    public ResultBean queryPlayerAllTeamById(@RequestParam(value = "playerId", required = true) Integer playerId){
        return ExceptionCatch.exceptionCatch(teamPlayerService, playerId.toString(), playerId);
    }

    @RequestMapping(value = "/api/teamAddPlayer", method = RequestMethod.GET)
    public ResultBean teamAddPlayer(@RequestParam(value = "playerId", required = true) Integer playerId,
                                    @RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamPlayerService, playerId.toString(),playerId, teamId);
    }

    @RequestMapping(value = "/api/playerAddTeam", method = RequestMethod.GET)
    public ResultBean playerAddTeam(@RequestParam(value = "playerId", required = true) Integer playerId,
                                    @RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamPlayerService, playerId.toString(),playerId, teamId);
    }

    @RequestMapping(value = "/api/updateIsAddPlayer", method = RequestMethod.GET)
    public ResultBean updateIsAddPlayer(@RequestParam(value = "isAddPlayer", required = true) Integer isAddPlayer,
                                        @RequestParam(value = "playerId", required = true) Integer playerId,
                                        @RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamPlayerService, playerId.toString(), isAddPlayer, playerId, teamId);
    }

    @RequestMapping(value = "/api/updateIsCameMatch", method = RequestMethod.GET)
    public ResultBean updateIsCameMatch(@RequestParam(value = "isCameMatch", required = true) Integer isCameMatch,
                                        @RequestParam(value = "playerId", required = true) Integer playerId,
                                        @RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamPlayerService, playerId.toString(), isCameMatch, playerId, teamId);
    }

    @RequestMapping(value = "/api/updateIsCameEnrol", method = RequestMethod.GET)
    public ResultBean updateIsCameEnrol(@RequestParam(value = "isCameEnrol", required = true) Integer isCameEnrol,
                                        @RequestParam(value = "playerId", required = true) Integer playerId,
                                        @RequestParam(value = "teamId", required = true) Integer teamId){
        return ExceptionCatch.exceptionCatch(teamPlayerService, playerId.toString(), isCameEnrol, playerId, teamId);
    }

    @RequestMapping(value = "/api/deleteTeamPlayer", method = RequestMethod.GET)
    public ResultBean deleteTeamPlayer(@RequestParam(value = "playerId", required = true) Integer playerId,
                                   @RequestParam(value = "teamId", required = true) Integer teamId,
                                   @RequestParam(value = "isCaptain", required = true) Integer isCaptain){
        return ExceptionCatch.exceptionCatch(teamPlayerService, playerId.toString(), playerId, teamId, isCaptain);
    }

}
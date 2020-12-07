package com.lazyi.controller;


import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.service.EnPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnPlayerController {


    @Autowired
    private EnPlayerService enPlayerService;

    @RequestMapping(value = "/api/queryEnPlayerList", method = RequestMethod.GET)
    public ResultBean queryEnPlayerList(){
        return ExceptionCatch.exceptionCatch(enPlayerService,"query");
    }

    @RequestMapping(value = "/api/queryEnPlayerByEnId", method = RequestMethod.GET)
    public ResultBean queryEnPlayerByEnId(@RequestParam(value = "enId") Integer enId){
        return ExceptionCatch.exceptionCatch(enPlayerService,enId.toString(),enId);
    }

    @RequestMapping(value = "/api/addEnPlayer", method = RequestMethod.GET)
    public ResultBean addEnPlayer(@RequestParam(value = "enId") Integer enId,
                                  @RequestParam(value = "playerId") Integer playerId){
        return ExceptionCatch.exceptionCatch(enPlayerService,enId.toString(),enId,playerId);
    }

    @RequestMapping(value = "/api/deleteEnPlayer",method = RequestMethod.GET)
    public ResultBean deleteEnPlayer(@RequestParam(value = "enId") Integer enId,
                                     @RequestParam(value = "playerId") Integer playerId){
        return ExceptionCatch.exceptionCatch(enPlayerService,enId.toString(),enId,playerId);
    }

    @RequestMapping(value = "/api/deletePlayerEnrol", method = RequestMethod.GET)
    public ResultBean deletePlayerEnrol(@RequestParam(value = "enId") Integer enId){
        return ExceptionCatch.exceptionCatch(enPlayerService,enId.toString(), enId);
    }
}

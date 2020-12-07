package com.lazyi.controller;

import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.service.EnrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrolController {

    @Autowired
    private EnrolService enrolService;

    @RequestMapping(value = "/api/queryEnrolList", method = RequestMethod.GET)
    public ResultBean queryEnrolList(){
        return ExceptionCatch.exceptionCatch(enrolService,"query");
    }

    @RequestMapping(value = "/api/queryEnrolByTeamId", method = RequestMethod.GET)
    public ResultBean queryEnrolByTeamId(@RequestParam(value = "teamId") Integer teamId){
        return ExceptionCatch.exceptionCatch(enrolService,teamId.toString(),teamId);
    }

    @RequestMapping(value = "/api/queryEnrolByEnId", method = RequestMethod.GET)
    public ResultBean queryEnrolByEnId(@RequestParam(value = "enId") Integer enId){
        return ExceptionCatch.exceptionCatch(enrolService,enId.toString(),enId);
    }

    @RequestMapping(value = "/api/addEnrol", method = RequestMethod.GET)
    public ResultBean addEnrol(@RequestParam(value = "teamId") Integer teamId,
                               @RequestParam(value = "teamName") String teamName,
                               @RequestParam(value = "teamNum") Integer teamNum,
                               @RequestParam(value = "fieldName") String fieldName,
                               @RequestParam(value = "isNeedReferee") Integer isNeedReferee,
                               @RequestParam(value = "time") String time){
        return ExceptionCatch.exceptionCatch(enrolService,teamName,teamId,teamName,teamNum,fieldName,isNeedReferee,time);
    }

    @RequestMapping(value = "/api/updateEnrol", method = RequestMethod.GET)
    public ResultBean updateEnrol(@RequestParam(value = "enId") Integer enId,
                                  @RequestParam(value = "teamNum") Integer teamNum,
                                  @RequestParam(value = "fieldName") String fieldName,
                                  @RequestParam(value = "isNeedReferee") Integer isNeedReferee,
                                  @RequestParam(value = "time") String time,
                                  @RequestParam(value = "goPlayerNum") Integer goPlayerNum,
                                  @RequestParam(value = "isShowing") Integer isShowing){
        return ExceptionCatch.exceptionCatch(enrolService,enId.toString(),enId,teamNum,fieldName,isNeedReferee,time,goPlayerNum,isShowing);
    }

    @RequestMapping(value = "/api/deleteEnrol", method = RequestMethod.GET)
    public ResultBean deleteEnrol(@RequestParam(value = "enId") Integer enId){
        return ExceptionCatch.exceptionCatch(enrolService,enId.toString(),enId);
    }
}

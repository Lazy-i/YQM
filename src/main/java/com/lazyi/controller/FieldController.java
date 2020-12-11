package com.lazyi.controller;

import com.lazyi.ExceptionCatch;
import com.lazyi.ResultBean;
import com.lazyi.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @RequestMapping(value = "/api/queryFieldById", method = RequestMethod.GET)
    public ResultBean queryFieldById(@RequestParam(value = "fieldId") Integer fieldId){
        return ExceptionCatch.exceptionCatch(fieldService, fieldId.toString(),fieldId);
    }

    @RequestMapping(value = "/api/queryFieldByFieldManagerId", method = RequestMethod.GET)
    public ResultBean queryFieldByFieldManagerId(@RequestParam(value = "fieldManagerId") Integer fieldManagerId){
        return ExceptionCatch.exceptionCatch(fieldService, fieldManagerId.toString(), fieldManagerId);
    }

    @RequestMapping(value = "/api/addField", method = RequestMethod.GET)
    public  ResultBean addField(@RequestParam(value = "fieldName") String fieldName,
                                @RequestParam(value = "fieldSpace") String fieldSpace,
                                @RequestParam(value = "openTime") String openTime,
                                @RequestParam(value = "fieldManagerId") Integer fieldManagerId){
        return ExceptionCatch.exceptionCatch(fieldService, fieldManagerId.toString(), fieldName, fieldSpace, openTime, fieldManagerId);
    }

    @RequestMapping(value = "/api/updateField", method = RequestMethod.GET)
    public ResultBean updateField(@RequestParam(value = "fieldName") String fieldName,
                                  @RequestParam(value = "fieldSpace") String fieldSpace,
                                  @RequestParam(value = "openTime") String openTime,
                                  @RequestParam(value = "fieldState") Integer fieldState,
                                  @RequestParam(value = "fieldManagerId") Integer fieldManagerId,
                                  @RequestParam(value = "fieldId") Integer fieldId){
        return ExceptionCatch.exceptionCatch(fieldService, fieldId.toString(), fieldName,fieldSpace,openTime,fieldState,fieldManagerId,fieldId);
    }

    @RequestMapping(value = "/api/updateFieldState", method = RequestMethod.GET)
    public ResultBean updateFieldState(@RequestParam(value = "fieldId") Integer fieldId,
                                       @RequestParam(value = "fieldState") Integer fieldState){
        return ExceptionCatch.exceptionCatch(fieldService, fieldId.toString(),fieldId, fieldState);
    }
}

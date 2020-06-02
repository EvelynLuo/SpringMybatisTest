package com.example.demo.controller;


import com.example.demo.entity.CommDisaster;
import com.example.demo.service.CommDisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/CommDisaster")
public class CommDisasterController {
    @Autowired(required = false)
    private  CommDisasterService commDisasterService;

    @RequestMapping("/index")
    public String map(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/getPage")
    public Map<String,Object> getPage(@RequestParam(value = "limit", required = true) Integer limit,
                                      @RequestParam(value = "offset", required = true) Integer offset){
        return commDisasterService.getPage(limit,offset);
    }


    @ResponseBody
    @RequestMapping("/insert")
    public int  InsertCD(CommDisaster commDisaster){
        return  commDisasterService.insert(commDisaster);
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public List<CommDisaster> findALL(){
        return  commDisasterService.findAll();
    }








}

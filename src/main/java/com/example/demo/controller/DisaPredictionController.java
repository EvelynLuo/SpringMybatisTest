package com.example.demo.controller;

import com.example.demo.entity.DisaPrediction;
import com.example.demo.service.DisaPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/testDisaP")
public class DisaPredictionController {
    @Autowired(required = false)
    private DisaPredictionService disaPredictionService;

    @RequestMapping("/index")
    public String map(){return "test";}

    @ResponseBody
    @RequestMapping("/getPage")
    public Map<String,Object> getPage(@RequestParam(value = "limit", required = true) Integer limit,
                                      @RequestParam(value = "offset", required = true) Integer offset){
        return disaPredictionService.getPage(limit,offset);
    }

    @ResponseBody
    @RequestMapping("/insert")
    public int InsertDP(DisaPrediction disaPrediction){return  disaPredictionService.insert(disaPrediction);}

    @ResponseBody
    @RequestMapping("/findAll")
    public List<DisaPrediction> findAll(){return disaPredictionService.findAll();}
}

package com.example.demo.service;



import com.example.demo.entity.TrafficDisaster;

import com.example.demo.mapper.TrafficDisasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrafficDisasterService {

    @Autowired(required = false)
    private  TrafficDisasterMapper mapper;


    public List<TrafficDisaster> queryAll(){return mapper.queryAll();}

    public TrafficDisaster query(String disasterID){return mapper.query(disasterID);}

    public int insert(TrafficDisaster trafficDisaster){return mapper.insert(trafficDisaster);}

    public int  delete(int id){return mapper.delete(id);}

    public int  delete19(String disasterID){return mapper.delete19(disasterID);}

    public  int update19(TrafficDisaster trafficDisaster){return mapper.update19(trafficDisaster);}


    public  int update(TrafficDisaster trafficDisaster){return mapper.update(trafficDisaster);}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<TrafficDisaster> userList = null;
        Integer total = 0;
        try {
            userList = mapper.getpage(offset,limit);
            total = mapper.findAllCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("data",userList);
        resultMap.put("total",total);
        return resultMap;
    }

    public List<TrafficDisaster> findAll(){
        return  mapper.findAll();
    }

}

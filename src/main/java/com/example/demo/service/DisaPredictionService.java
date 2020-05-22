package com.example.demo.service;

import com.example.demo.entity.CollRecord;
import com.example.demo.entity.DisaPrediction;
import com.example.demo.mapper.DisaPredictionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DisaPredictionService {
    @Autowired(required = false)
    private DisaPredictionMapper disaPredictionMapper;

    public DisaPrediction query(String disasterID) {
        return disaPredictionMapper.query(disasterID);
    }

    public List<DisaPrediction> queryAll() {
        return disaPredictionMapper.queryAll();
    }

    public int insert(DisaPrediction dp) {
        return disaPredictionMapper.insert(dp);
    }

    public int delete(int ID) {
        return disaPredictionMapper.delete(ID);
    }

    public int update(DisaPrediction dp) {
        return disaPredictionMapper.update(dp);
    }

    public Map<String, Object> getPage(Integer limit, Integer offset) {
        Map<String, Object> resultMap = new HashMap();
        List<DisaPrediction> userList = null;
        Integer total = 0;
        try {
            userList = disaPredictionMapper.getpage(offset, limit);
            total = disaPredictionMapper.findAllCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultMap.put("data", userList);
        resultMap.put("total", total);
        return resultMap;
    }

    public List<DisaPrediction> findAll() {
        return disaPredictionMapper.findAll();
    }
}

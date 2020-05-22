package com.example.demo.service;

import com.example.demo.entity.CivilStructure;
import com.example.demo.entity.CollRecord;
import com.example.demo.mapper.CivilSMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CivilSService {
    @Autowired(required = false)
    private CivilSMapper civilSMapper;

    public CivilStructure query(String disasterID){return civilSMapper.query(disasterID);}

    public int insert(CivilStructure structure){return civilSMapper.insert(structure);}

    public int update(CivilStructure civilStructure){return civilSMapper.update(civilStructure);}

    public int delete(int ID){return civilSMapper.delete(ID);}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<CivilStructure> userList = null;
        Integer total = 0;
        try {
            userList = civilSMapper.getpage(offset,limit);
            total = civilSMapper.findAllCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("data",userList);
        resultMap.put("total",total);
        return resultMap;
    }
    public List<CivilStructure> findAll(){return civilSMapper.findAll();}
}

package com.example.demo.service;

import com.example.demo.entity.MasonryStructure;
import com.example.demo.mapper.MasonryStructureMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasonryStructureService {
    @Autowired(required = false)
    private MasonryStructureMapper mapper;

    public MasonryStructure query(String disasterID){return mapper.query(disasterID);}

    public int insert(MasonryStructure structure){return mapper.insert(structure);}

    public int update(MasonryStructure masonryStructure){return mapper.update(masonryStructure);}

    public int delete(int ID){return mapper.delete(ID);}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<MasonryStructure> userList = null;
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
    public List<MasonryStructure> findAll(){return mapper.findAll();}
}

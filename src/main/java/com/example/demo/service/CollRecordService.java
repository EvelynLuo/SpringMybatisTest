package com.example.demo.service;

import com.example.demo.entity.CollRecord;
import com.example.demo.entity.CommDisaster;
import com.example.demo.mapper.CollRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollRecordService {

    @Autowired(required = false)
    private CollRecordMapper collRecordMapper;

    public CollRecord query(int id){return collRecordMapper.query(id);}//按照19位编码查询查询

    public List<CollRecord> queryAll(){return collRecordMapper.queryAll();}//全部查询

    public int insert(CollRecord collRecord){return collRecordMapper.insert(collRecord);}//插入一条新数据

    public int delete(int id){return collRecordMapper.delete(id);}//按照id删除

    public int update(CollRecord collRecord){return collRecordMapper.update(collRecord);}//修改数据

    public List<CollRecord> query19(String disasterID){return collRecordMapper.query19(disasterID);}//按照19位编码查询

    public int delete19(String disasterID){return collRecordMapper.delete19(disasterID);}

    public int update19(CollRecord collRecord){return collRecordMapper.update19(collRecord) ;}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<CollRecord> userList = null;
        Integer total = 0;
        try {
            userList = collRecordMapper.getpage(offset,limit);
            total = collRecordMapper.findAllCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("data",userList);
        resultMap.put("total",total);
        return resultMap;
    }
    public List<CollRecord> findAll(){return collRecordMapper.findAll();}
}

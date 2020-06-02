package com.example.demo.mapper;



import com.example.demo.entity.TrafficDisaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TrafficDisasterMapper {

    List<TrafficDisaster> queryAll();//全部查询

    int insert(TrafficDisaster trafficDisaster);//插入一条新数据

    int delete(int id);//按照id删除

    int update(TrafficDisaster trafficDisaster);//修改数据

    TrafficDisaster query(String disasterID);//按照19位编码查询

    int delete19(String disasterID);

    int update19(TrafficDisaster trafficDisaster);

    List<TrafficDisaster> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<TrafficDisaster> findAll();



}

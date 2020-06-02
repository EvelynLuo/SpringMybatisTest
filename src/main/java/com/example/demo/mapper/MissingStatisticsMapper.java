package com.example.demo.mapper;

import com.example.demo.entity.MissingStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MissingStatisticsMapper {
    MissingStatistics query(String disasterID);
    int insert(MissingStatistics missingStatistics);
    int delete(int id);
    List<MissingStatistics> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<MissingStatistics> findAll();
}

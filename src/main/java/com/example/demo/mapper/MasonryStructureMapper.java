package com.example.demo.mapper;

import com.example.demo.entity.MasonryStructure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface MasonryStructureMapper {
        MasonryStructure query(String disasterID);//按照id查询查询
        int insert(MasonryStructure masonryStructure);//插入一条新数据
        int delete(int id);//按照id删除
        int update(MasonryStructure masonryStructure);//修改数据
        List<MasonryStructure> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);
        Integer findAllCount();
        List<MasonryStructure> findAll();
}


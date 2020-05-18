package com.example.demo.mapper;

import com.example.demo.entity.CollRecord;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollRecordMapperTest {

    private static SqlSession sqlSession = null;
    private static SqlSessionFactory sqlSessionFactory = null;

    @BeforeAll
    static void beforeAll() throws IOException {
        //读取mybatis-config.xml文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        //初始化mybatis,创建SqlSessionFactory类的实例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    void queryCR() {

        CollRecord cr = sqlSession.selectOne("com.example.demo.mapper.CollRecordMapper.queryCR",1);
        System.out.println(cr.toString());
    }

    @Test
    void queryAllCRs() {
        List<CollRecord> list = sqlSession.selectList("com.example.demo.mapper.CollRecordMapper.queryAllCRs");
        System.out.println("size:"+list.size());
    }

    @Test
    void insertCR() {
        CollRecord cd = new CollRecord();
        cd.setDisasterID("testinsert");
        cd.setDisasterDate("202005111803");
        int result = sqlSession.insert("com.example.demo.mapper.CollRecordMapper.InsertCR",cd);
        sqlSession.commit();
        if (result > 0)
            System.out.println("存储成功");
        else System.out.println("存储失败");
    }

    @Test
    void deleteCR() {
        int result = sqlSession.delete("com.example.demo.mapper.CollRecordMapper.DeleteCR",4);
        if (result > 0)
            System.out.println("删除成功");
        else System.out.println("删除失败");
    }

    @Test
    void updateCR() {
        CollRecord cr = new CollRecord();
        cr.setIdCollRecord(3);
        cr.setNote("only set note testing update");
        int result = sqlSession.update("com.example.demo.mapper.CollRecordMapper.UpdateCR",cr);
        sqlSession.commit();
        if (result > 0)
            System.out.println("更新成功");
        else System.out.println("更新失败");
    }

    @Test
    void queryCR19() {
    }

    @Test
    void deleteCR19() {
    }

    @Test
    void updateCR19() {
    }
}
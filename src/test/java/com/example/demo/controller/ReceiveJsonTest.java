package com.example.demo.controller;

import com.example.demo.entity.CommDisaster;
import com.example.demo.mapper.*;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveJsonTest {

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
    void getReturnURL() {

        for (int i = 0; i < 10; i++) {
            Integer[] type = new Integer[]{111, 113, 221, 223, 331, 336, 441, 442, 551, 552};
            String[] name = new String[]{"DeathStatistics", "MissingStatistics"
                    , "CivilStructure", "MasonryStructure", "TrafficDisaster", "CommDisaster"
                    , "CollRecord", "LandslideRecord", "DisasterInfo", "DisaPrediction"};
            System.out.println("\\" + type[i] + "\\" + name[i] + ".json");
        }
    }


}
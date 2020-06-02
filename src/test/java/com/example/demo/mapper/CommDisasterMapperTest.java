package com.example.demo.mapper;

import com.example.demo.entity.CivilStructure;
import com.example.demo.entity.CommDisaster;
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

class CommDisasterMapperTest {

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
    void insert() {
        CommDisaster d = new CommDisaster();
        d.setDisasterID("1234567891234562111");
        d.setDisasterDate("202005131044");
        d.setLocation("单元省测试");
        d.setReportingUnit("111");
        int result = sqlSession.insert("com.example.demo.mapper.CommDisasterMapper.insert",d);
        sqlSession.commit();
        if (result > 0)
            System.out.println("存储成功");
        else System.out.println("存储失败");
    }

    @Test
    void saveToURL() {
        StringBuffer[] sb = new StringBuffer[10];
        sb[5]=new StringBuffer("");
        JSONObject combine = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        String url;
        Integer[] type = new Integer[]{111, 113, 221, 223, 331, 336, 441, 442, 551, 552};
        String[] name = new String[]{"DeathStatistics", "MissingStatistics"
                , "CivilStructure", "MasonryStructure", "TrafficDisaster", "CommDisaster"
                , "CollRecord", "LandslideRecord", "DisasterInfo", "DisaPrediction"};
        //int result = sqlSession.insert("com.example.demo.mapper.CommDisasterMapper.insert",d);
        List<CommDisaster> list336 = sqlSession.selectList("com.example.demo.mapper.CommDisasterMapper.findAll");
        sqlSession.commit();
        for (CommDisaster commDisaster : list336) {
            jsonObject = JSONObject.fromObject(commDisaster);
            combine.put(new String(name[5]+commDisaster.getIdCommDisaster()),jsonObject);
        }
        sb[5].append(combine.toString());
        System.out.println(sb[5]);
        try {
            File file = null;
            BufferedWriter writer = null;
            PrintWriter out = null;
            //获取当前服务器地址
            InetAddress address = InetAddress.getLocalHost();
            url = address.getHostAddress();
            int i = 5;
            file = new File(url + "\\" + type[i]);
            //首先需要建立目录
            file.mkdirs();
            file = new File(url + "\\" + type[i] + "\\" + name[i] + ".json");
            //创建文件
            if (!file.exists()) {
                file.createNewFile();
            }

            //写入
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
            out = new PrintWriter(writer);
            out.write(String.valueOf(sb[i]));
            out.println();

            writer.close();
            out.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
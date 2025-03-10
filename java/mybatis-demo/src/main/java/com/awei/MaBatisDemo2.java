package com.awei;

import com.awei.mapper.UserMapper;
import com.awei.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//MyBatis代理开发
public class MaBatisDemo2 {
    public static void main(String[] args) throws IOException {
        //加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//


        //获取SqlSession对象，用他来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //执行sql
//        List<User> users = sqlSession.selectList("test.selectAll");
//3.获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();


        // 遍历输出查询到的数据
        for (User user : users) {
            System.out.println(user);
        }
            //释放资源
            sqlSession.close();
//        System.out.println(users);
//        }
    }
}
package com.awei.test;

import com.awei.mapper.BrandMapper;
import com.awei.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //释放资源
        sqlSession.close();
    }






        @Test
        public void testSelectById() throws IOException {
        //接受参数
            int id=1;


        //获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
            Brand brand = brandMapper.selectById(id);
            System.out.println(brand);

            //释放资源
        sqlSession.close();
    }




    @Test
    public void testSelectByCondition() throws IOException {
        //接受参数
        int status=1;
        String companyName="华为";
        String brandName="华为";

        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

        //封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);


        //获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
//        List<Brand> brands= brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands= brandMapper.selectByCondition(brand);
        List<Brand> brands= brandMapper.selectByCondition(map);
        System.out.println(brands);

        //释放资源
        sqlSession.close();
    }

}













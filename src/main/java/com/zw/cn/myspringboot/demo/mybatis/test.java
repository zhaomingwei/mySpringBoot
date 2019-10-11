package com.zw.cn.myspringboot.demo.mybatis;

import com.zw.cn.myspringboot.entity.User;
import com.zw.cn.myspringboot.mapper.UserMapper;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/8/19
 * Time: 9:54
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@Logger
public class test {

    public static void main(String[] args) {
        String resource = "mybatis/mybatis-config.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectByPrimaryKey("1");
            System.out.println("user:" + user);
            System.out.println("使用同一个SqlSession在执行一次");
            User user1 = userMapper.selectByPrimaryKey("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

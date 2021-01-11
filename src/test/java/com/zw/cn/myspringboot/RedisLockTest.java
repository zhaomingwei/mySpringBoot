package com.zw.cn.myspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2020/5/12
 * Time: 8:25
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisLockTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisLock(){
        stringRedisTemplate.opsForValue().set("testkey5", "4444555", 5 * 60, TimeUnit.SECONDS);
        String oo = stringRedisTemplate.opsForValue().get("testkey5");
        System.out.println("=======" + oo);
    }

}

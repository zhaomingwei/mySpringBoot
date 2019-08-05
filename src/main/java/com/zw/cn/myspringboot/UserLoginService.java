package com.zw.cn.myspringboot;

import com.zw.cn.myspringboot.entity.User;
import com.zw.cn.myspringboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZhaoWei on 2019/8/5/0005.
 */
@Service
public class UserLoginService {
    /**
     * 注入dao
     */
    @Autowired
    private UserMapper usermapper;

    //用户登录
    public User userLogin(String username, String password){
        User user = usermapper.userLogin(username,password);
        return user;
    }

    //注册新用户
    public int addUser(String username,String password,int age){
//        return usermapper.addUser(username,password,age);
        return usermapper.addUser1(username,password,age);     //对应sql语句中的第二种注册方式
    }

}

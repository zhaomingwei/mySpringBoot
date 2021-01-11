package com.zw.cn.myspringboot.demo.threadTest;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/10/14
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }
}

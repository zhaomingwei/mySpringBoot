package com.zw.cn.myspringboot.demo;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/8/8
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class App {

    public static void main(String[] args) {
        ConcurrentLinkedQueue list = new ConcurrentLinkedQueue();
        list.offer(1);
        list.offer(2);
        list.offer(3);
        list.offer(4);
        list.peek();
        list.poll();
    }

}

package com.zw.cn.myspringboot.demo.threadTest;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/9/19
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }
    public static class Domino implements Runnable{
        private  Thread thread;
        public Domino(Thread previous) {
            this.thread = previous;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}

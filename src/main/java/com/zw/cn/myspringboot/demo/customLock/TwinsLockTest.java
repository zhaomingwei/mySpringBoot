package com.zw.cn.myspringboot.demo.customLock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/10/22
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class TwinsLockTest {

    @Test
    public void Test() throws InterruptedException {
        final Lock lock = new TwinsLock();
        class Woker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        for(int i=0;i<10;i++){
            Woker w = new Woker();
//            w.setDaemon(true);
            w.start();
        }
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println();
        }
    }

}

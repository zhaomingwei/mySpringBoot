package com.zw.cn.myspringboot.demo.customLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/10/24
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class BoundedQueue<T> {
    private Object[] items;
    private int addIndex,removeIndex,count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size) {
        this.items = new Object[size];
    }
    //添加一个元素，如果数组满了，则添加线程进入等待状态，直到有空位
    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            //数组满了，等待
            while (count == items.length){
                notFull.await();
            }
            items[addIndex] = t;
            //下标问题
            if(++addIndex == items.length){
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }
    //由头部删除一个元素，如果数组为空，则删除线程进入等待状态，直到有新元素添加进来
    public Object remove() throws InterruptedException {
        lock.lock();
        try {
            while (count==0){
                notEmpty.await();
            }
            Object x = items[removeIndex];
            if(++removeIndex == items.length){
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            return x;
        }finally {
            lock.unlock();
        }
    }
}

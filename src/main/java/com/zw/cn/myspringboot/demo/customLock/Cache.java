package com.zw.cn.myspringboot.demo.customLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/10/23
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class Cache {
    static Map map = new HashMap();
    static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    static Lock r = rw.readLock();
    static Lock w = rw.writeLock();
    public static final Object get(String key){
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }
    public static final Object put(String key, Object value){
        w.lock();
        try {
            return map.put(key, value);
        }finally {
            w.unlock();
        }
    }
    public static final void clear(){
        w.lock();
        try {
            map.clear();
        }finally {
            w.unlock();
        }
    }
}

package com.zw.cn.myspringboot.demo.strage;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/8/8
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public abstract class InspectionSolver {
    public abstract void solve(Long orderId, Long userId);
    public abstract String[] supports();
}

package com.zw.cn.myspringboot.demo.ifelse2strage;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/8/8
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@Component
public class ReplaceOrderGoodsSolver implements InspectionSolver {
    @Override
    public void solve(Long orderId, Long userId) {
        System.out.println("订单:" + orderId + "开始进行替换商品了。。。");
    }

    @Override
    public String[] supports() {
        return new String[]{InspectionConstant.INSPECTION_TASK_3};
    }
}

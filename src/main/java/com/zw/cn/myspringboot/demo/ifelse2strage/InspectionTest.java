package com.zw.cn.myspringboot.demo.ifelse2strage;

import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/8/8
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)//指定springboot启动方式
public class InspectionTest {
    @Autowired
    private InspectionSolverChooser chooser;
    @Test
    public void test() throws Exception{
        //数据准备
        String taskType = InspectionConstant.INSPECTION_TASK_1;
        Long orderId = 12345L;
        Long userId = 123L;
        //获取任务类型对应的solver
        InspectionSolver solver = chooser.choose(taskType);
        if(null == solver){
            throw new RuntimeException("任务类型暂时无法处理!");
        }
        //调用不同solver的方法进行处理
        solver.solve(orderId, userId);
    }
}

package com.zw.cn.myspringboot.demo.ifelse2strage;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/8/8
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@Component
public class InspectionSolverChooser implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<String, InspectionSolver> chooseMap = new HashMap<>();

    public InspectionSolver choose(String type){
        return chooseMap.get(type);
    }

    @PostConstruct
    public void register(){
        Map<String, InspectionSolver> solverMap = applicationContext.getBeansOfType(InspectionSolver.class);
        for(InspectionSolver solver : solverMap.values()){
            for(String support : solver.supports()){
                chooseMap.put(support, solver);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

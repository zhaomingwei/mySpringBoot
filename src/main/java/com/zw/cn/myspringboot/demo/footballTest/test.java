package com.zw.cn.myspringboot.demo.footballTest;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/10/11
 * Time: 8:55
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class test {

    public static void main(String[] args) {
        test(2, 2, 20, 6.1);
    }

    /**
     * @param baseNum 基数
     * @param step 几倍增加
     * @param num 次数
     * @param m 中奖倍数
     */
    public static void test(int baseNum, int step, int num, double m){
        if(baseNum<1 || step<1 || num<1){
            System.out.println("任意参数小于1");
        }
        int sum = 0 ;
        for(int i=0;i<=num;i++){
            int bn = 0;
            if(i==0){
                bn = baseNum;
            }else{
                bn = baseNum * (int)Math.pow(step, i);
            }
            sum = sum + bn;
            double profit = bn * m - sum;
            System.out.println("当次成本:"+bn+",总成本:"+sum+",如果当次中奖,奖金减去总成本:"+profit+",倍数:"+step+",当前次数:"+i);
        }
    }

}

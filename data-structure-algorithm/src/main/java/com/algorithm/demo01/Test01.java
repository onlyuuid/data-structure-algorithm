package com.algorithm.demo01;

import org.junit.Test;

public class Test01 {
    @Test
    public void test01(){
        /**
         * 题目: 等差数列求和  [0,1,1,2,3,5,8,13,...]
         * 给定一个正整数N，返回从1到N的累加和
         */
        long startTime = TimeTool.getCurrentTime();
        // 获取索引为45的等差数列的值
        int recursion = recursion(45);
        long endTime = TimeTool.getCurrentTime();
        long timeDifference = TimeTool.getTimeDifference(startTime,endTime);
        System.out.println("递归结果:" + recursion);
        System.out.println("耗时:" + timeDifference +"s");

        long startTime2 = TimeTool.getCurrentTime();
        // 获取索引为45的等差数列的值
        int forEach = forEach(45);
        long endTime2 = TimeTool.getCurrentTime();
        long timeDifference2 = TimeTool.getTimeDifference(startTime2,endTime2);
        System.out.println("遍历结果:" + forEach);
        System.out.println("耗时:" + timeDifference2 +"s");

        /**
         * 递归结果:1134903170
         * 耗时:2743s
         *
         * 遍历结果:1134903170
         * 耗时:0s
         */
    }

    /**
     * 递归
     * @param n 元素索引
     */
    public int recursion(int n){
        if(n <= 1){
            return n;
        }
        return recursion(n - 1) + recursion(n - 2) ;
    }

    /**
     * 遍历
     *  @param n 元素索引
     */
    public int forEach(int n){
        if(n <= 1){
            return n;
        }
        int sum;
        int frist = 1; // 前一项数据值
        int scode = 0; // 前两项数据值
        for(int i = 0; i < n; i++){ // 1 1 1  1 2 2  2 3 3
            sum = frist + scode;
            frist = scode;
            scode = sum;
        }
        return scode;
    }
}

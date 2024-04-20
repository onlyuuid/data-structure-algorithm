package com.algorithm.demo03;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort_01 {

    @Test
    public void test01() {
        Integer[] arr = {32,1,5,87,14,53,64,76,8,15};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] < arr[j+1]){
                    replace(j,j+1,arr);
                }
            }
        }
        System.out.println("排序结果: " + Arrays.toString(arr));
    }

    /**
     * 位运算替换
     */
    public Integer[] replace(Integer last,Integer next,Integer[] arr){
           arr[last] = arr[last] ^ arr[next];
           arr[next] = arr[last] ^ arr[next];
           arr[last] = arr[last] ^ arr[next];
           return arr;
    }
}

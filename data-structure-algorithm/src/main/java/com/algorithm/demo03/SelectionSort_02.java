package com.algorithm.demo03;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort_02 {

    @Test
    public void test01(){
        // 定义一个无序数组
        Integer[] arr = {32,3,1,13,54,43,123,43,65,87,89};

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        System.out.println("选择排序: " + Arrays.toString(arr));
    }
}

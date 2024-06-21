package com.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {

    @Test
    public  void test01() {
        // 定义一个未排序的数组
        Integer[] sort = {102,3,42,5,43,65,12,43,59,11,5,20};
        Integer[] integers = installSort(sort);
        System.out.println("integers = " + Arrays.toString(integers));  // 102 3 42 5   3 102 42 5   3 42 102 5    3 5 42 102
    }

    /**
     * 插入排序
     * @param sort 需要排序的数组
     * @return
     */
    public Integer[] installSort(Integer[] sort){
        for (int i = 1; i < sort.length; i++) {
            int key = sort[i];
            int j = i - 1;
            // 将大于key的值向后移
            while (j >= 0 && sort[j] > key){
                sort[j+1] = sort[j];
                j = j - 1;
            }
            // 将元素插入到合适的位置
            sort[j+1] = key;
        }
        return sort;
    }



}

package com.algorithm.search;

import org.junit.Test;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 题目一: 在一个有序数组中, 查找某个数是否存在, 如果存在返回这个数
     */
    @Test
    public void test(){
        // 初始化数组
        int[] arr = {1,2,3,4,5,7,8,9,10,13,14,15};
        int search = search(arr, 6);
        System.out.println("search = " + search);

    }

    /**
     * 搜索方法
     * @param arr 数组
     * @param target 目标数
     * @return 结果数据, 没有找到返回-1
     */
    public int search(int[] arr, int target) {
        int len = arr.length;
        int start = 0;
        int end = len - 1;
        int mid = (start + end) / 2;
        for (int i = 0; i < len; i++) {
            if(arr[mid] < target){
               start = mid + 1;
               mid = (start + end) / 2;
           }else if(arr[mid] > target){
               end = mid - 1;
               mid = (start + end) / 2;
           }else {
                return arr[mid];
           }
        }
        return -1;
    }

    /**
     * 题目二: 在一个有序数组中, 求大于等于某一个数最左侧的位置
     */

    /**
     * 题目三: 局部最小值问题
     */


}

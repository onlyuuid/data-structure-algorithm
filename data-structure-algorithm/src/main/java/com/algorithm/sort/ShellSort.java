package com.algorithm.sort;

<<<<<<< HEAD
import java.util.Arrays;

/**
 * @author: WuPeng
 * @description: 希尔排序
 * @date: 2024/10/7 10:59
 */

public class ShellSort {
    /**
     * 思路: 1.对未排序数组进行分组
     *      2.对分组使用插入排序
     *      3.再次进行分组并使用插入排序
     * 希尔排序目是对插入排序的优化, 目的是将乱序数组先变为一个准有序数组, 最后再次使用插入排序使其成为一个有序数组
     * @param arr 未排序数组
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        // 按照数组长度的一半进行分组 gap为分组间隔
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 分组进行插入排序
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void shellSort2(int[] arr) {
        int size = arr.length;
        // 对数组进行分组 gap为分组间隔
        for(int gap = size/2;gap > 0;gap/=2){
            // 对分组元素分别进行插入排序
            for (int i = gap; i < size; i++) {
                int temp = arr[i];
                int j;
                for (j = i;j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j]=arr[j - gap];
                }
                arr[j]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 34,4, 54, 2,8, 3};
        shellSort2(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
=======
/**
 * 希尔排序
 */
public class ShellSort {

>>>>>>> 69b07c9775cc5b5ace55f23fafbdc482007bffa5
}

package com.algorithm.sort;

/**
 * @author: WuPeng
 * @description: 堆排序
 * @date: 2024/9/28 11:00
 */

public class HeapSort {

//    public static void heapSort(int[] arr) {
//        int n = arr.length;
//
//        // 构建大顶堆
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapify(arr, n, i);
//        }
//
//        // 排序过程
//        for (int i = n - 1; i > 0; i--) {
//            // 将堆顶元素与最后一个元素交换
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
//
//            // 对剩余的元素重新调整为大顶堆
//            heapify(arr, i, 0);
//        }
//    }
//
//    private static void heapify(int[] arr, int n, int i) {
//        int largest = i;
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//
//        // 如果左子节点大于根节点，则更新 largest
//        if (left < n && arr[left] > arr[largest]) {
//            largest = left;
//        }
//
//        // 如果右子节点大于根节点，则更新 largest
//        if (right < n && arr[right] > arr[largest]) {
//            largest = right;
//        }
//
//        // 如果 largest 不是根节点，则交换并继续调整
//        if (largest!= i) {
//            int swap = arr[i];
//            arr[i] = arr[largest];
//            arr[largest] = swap;
//
//            heapify(arr, n, largest);
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 13, 5, 14, 21, 19};
        heapSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 排序过程
    public static void heapSort(int[] arr){
        int size = arr.length;
        // 构建大顶堆
        for (int i = size/2-1; i >= 0; i--) {  // -- 切换堆的层级
            heapify(arr,size,i);
        }

        // 排序过程
        for(int i = size - 1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 对剩余的元素继续构造大顶堆
            heapify(arr,i,0);
        }

    }

    public static void heapify(int[] arr,int n,int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // 如果左子节点大于父节点,则更新largest
        if(left < n && arr[left] >= arr[largest]){
            largest = left;
        }

        // 如果右子节点大于父节点,则更新largest
        if(right < n && arr[right] >= arr[largest]){
            largest = right;
        }

        // 如果 largest 不是根节点,则交换并继续调整
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr,n,largest);
        }

    }



}

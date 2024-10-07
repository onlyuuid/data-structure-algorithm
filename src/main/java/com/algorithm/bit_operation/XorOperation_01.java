package com.algorithm.bit_operation;

import org.junit.Test;

/**
 * 异或运算
 */
public class XorOperation_01 {

    /**
     * 题目一: 已知一个数组中某个数有奇数个, 其他的数有偶数个, 请使用算法求这个奇数的值:
     */
    @Test
    public void test01() {
       int[] arr = {32, 43, 43, 32, 3, 6, 3, 3, 6};
        int x = 0;
        for (Integer tmp : arr) {
            x ^= tmp;
        }
        System.out.println("这个数为: " + x);
    }

    /**
     * 题目二: 已知一个数组中某两个数a,b有奇数个,且a!=b, 其他的数有偶数位, 分别求出这两个数a,b的值:
     */
    @Test
    public void test02() {
        int[] arr = {32,43,43,6,6,54,54,3,3,3,6,11,11,32,6,11}; // 32*2 43*2 3*3 6*4 11*3 54*2
        int x = 0;
        for (int tmp : arr) {
            x ^= tmp;
        }
        // x = a ^ b
        int rightOne = x & (~x + 1);  // 提取a或b最右侧的1
        int x_ = 0;
        for (int tmp : arr) {
            if((tmp & rightOne) != 0) {
                x_ ^= tmp;
            }
        }
        // x_ = a or b
        int a = x_;        // 令 a = x_
        int b = x_ ^ x;    // 令 b = x_ ^ x
        System.out.println("求得: a = "+a + ", b = "+b); // 求得: a = 0, b = 8


    }
}

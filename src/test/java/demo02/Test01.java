package demo02;

import org.junit.Test;

import java.util.Arrays;

public class Test01 {
    // 通常在包含高阶项的算法估测中, 我们去掉低阶项,去掉常数项,只要高阶项, 如: 3n^2 + 5n + 4 = O(n^2) 记作平方阶
    /**
     *  测试计算
     */
    @Test
    public void test01(){
        int a = 1;
        int b = 3;
        int c = a + b;
        System.out.println("c = " + c);

        /**
         * 如果把执行每行代码的时间记作 1个unitTime , 那么执行上面这段程序共耗时 4 个unitTime
         * 如果执行所需要的时间与数据规模无关, 那么这样的算法我们称为常数阶, 记作: O(1)
         */
    }

    /**
     * 测试判断
     */
    @Test
    public void test02(){
        int a = 1;
        int b = 3;
        if(a > b){
            System.out.println("a > b");
        }else{
            System.out.println("a < b");
        }
        System.out.println("hello world");

        /**
         * 如果把执行每行代码的时间记作 1个unitTime , 那么执行上面这段程序共耗时 5个unitTime
         * 如果执行所需要的时间与数据规模无关, 那么这样的算法我们称为常数阶, 记作: O(1)
         */
    }

    /**
     * 测试循环
     */
    @Test
    public void test03(){
        Integer[] arr = {1,32,3,43,54,65,76,7};
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                System.out.println("arr中为偶数的是:"+arr[i]);
            }
        }

        /**
         * 如果把执行每行代码的时间记作 1个unitTime , 那么执行上面这段程序共耗时与数组的长度有关, 假设数组长度为n, 那么上面程序执行的时间为:
         * 1 + 1 + n + n + n = 3n + 2
         *
         * 如果执行所需要的时间与数据规模成线性关系, 那么这样的算法我们称为线性阶, 记作: O(n)
         */
    }

    /**
     * 测试嵌套循环
     */
    @Test
    public void test04(){
        /**
         * 冒泡排序
         */
        Integer[] arr = {54,3,43,13,2,4,9,65,76,7};
        Integer[] sorted = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
               if(arr[j] < arr[j+1]){
                   sorted = replace(j, j + 1, arr);
               }
            }
        }
        System.out.println("arr = " + Arrays.toString(sorted));

        /**
         * 如果把执行每行代码的时间记作 1个unitTime , 那么执行上面这段程序共耗时与数组的长度有关, 假设数组长度为n, 那么上面程序执行的时间为:
         * 1 + 1 + 1 + n + n + n * (1 + n-1 + n-1 + n-1) + 1
         * = 3 + 2n + n*(3n-2)+1
         * = 3 + 2n + 3n^2 - 2n + 1
         * = 3n^2 + 4
         *
         * 如果执行所需要的时间与数据规模成平方关系, 那么这样的算法我们称为平方阶, 记作: O(n^2)
         * 以此类推, 如果成对数关系, 那就成为对数阶, 记作: O(logn), 立方阶, 记作: O(n^3)
         */
    }

    /**
     * 将后一位数字与前一位数字进行替换
     * @param first 前一位
     * @param end   后一位
     */
    public Integer[] replace(Integer first,Integer end,Integer[] arr){
        arr[first] = arr[first] ^ arr[end];
        arr[end] = arr[first] ^ arr[end];
        arr[first] = arr[first] ^ arr[end];
        return arr;
    }
}

# data-structure-algorithm

# 一. 简介

​       算法在当今的程序中发挥着非常重要的作用, 小到一块计算器, 大到卫星系统都有算法存在的身影, 那么什么是算法呢? 算法是解题方案的准确的描述, 是一系列解决问题的清晰的指令, 指系统的方法描述解决问题的策略机制。

**定义：**T(n) = O(f(n))  

**描述:** 程序执行的时间和它的规模量成正比, n 表示数据规模

![img](https://cdn.nlark.com/yuque/0/2024/jpeg/39135265/1713161117938-ef32469b-dec5-42da-b859-366fdb26a26d.jpeg)

**为什么要学习算法：**

- 学习算法可以让我们更加明白程序的执行过程
- 可以帮助我们开发出性能更好的应用程序

# 二. 认识复杂度

## 1. 时间复杂度

​       时间复杂度是衡量一个算法优劣的重要标准, 他指运行一个方法所用的时长, 时长越短则说明该算法执行效率越高, 反之则越低。

**常见的时间复杂度有：**

- O(1)			常数阶
- O(n)			线性阶
- O(n^2)    	       平方阶
- O(n^3)    	       立方阶
- O(logn)    	      对数阶
- O(2^n)    	       指数阶

**函数图形:**

![img](https://cdn.nlark.com/yuque/0/2024/png/39135265/1713167267500-5f2676d8-39f1-42be-b7bf-abc843790fff.png)

通常来说, 在我们程序开发的过程中, 当某个方法的算法如果高于平法阶(O(n^2)), 那么就需要考虑对该方法进行优化了, 不然可能会造成程序体验感非常差。

​      写在最后, 前面我们提到的时间复杂度是只考虑最坏情况下的，我们一般也只考虑最坏情况。当然也有最优情况的发生，比如你在进行一个冒泡排序算法时，恰好数组里的数据就是从大到小排列的，这种情况不论你用何种梯度的算法，可能都影响程序运行的效率，但这种如同做梦般的理想情况在真实场景中很难遇到，大多数遇到的情况是不好也不坏，也就是一般情况，但是我们必须考虑程序最差的情况是什么，只要为最差情况“兜了底”，解决了最差情况下的场景，那么最优和一般场景我们就不用考虑了。

### 1.1 调试法

​      那么如何评判一个算法的执行效率是否优良，我们可以写一个运行时间计算的方法来通过运行我们的程序在控制台打印出程序执行所用的时间

```java
package com.algorithm.day01;

import org.junit.Test;

public class Test01 {
    @Test
    public void test01(){
        /**
         * 题目: 求索引为n的等差数列的值  [0,1,1,2,3,5,8,13,...]
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
```

通过实际运行观察不同算法的执行时间, 判断出哪个算法执行效率高, 从而采用哪个算法。这中方式直观且真实，但非常依赖我们的测试的数据规模，而且使用这种方式判断一个算法的优良效率非常低。

### 1.2 估测法（推荐）

​       估测法相比较调试法来说虽没有那么直观，但可以让我们快速的看出一个算法的好坏，提高我们的开发效率。

```java
package com.algorithm.dome02;

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
```

通过上述代码, 我们可以快速的看出一个算法属于什么梯度, 然后再根据我们可能传入的数据规模, 从而估测出该算法所执行的时间。

通常来说，如果一个算法的梯度大于平方阶，那么我们就要考虑如何进行优化了，否则可能会导致程序体验效果非常差。

**平均复杂度:**

![img](https://cdn.nlark.com/yuque/0/2024/png/39135265/1713592093595-9563a35d-389f-4a99-a616-127f95bf08b3.png)

**拓展:**

![img](https://cdn.nlark.com/yuque/0/2024/png/39135265/1713592274043-e23ab8e6-c055-4aff-8af3-d903809dad54.png)

## 2. 空间复杂度

​       时间复杂度是描述某个算法所用的时间，而空间复杂度是描述某个算法执行时所消耗的空间（如内存空间）。几十年前，杰出的科学家们凭借自己能力创造出非常卓越的算法，以至于在内存，硬盘，CUP 资源非常有限的条件下（kb 级别）让卫星发射成功，实在让人敬佩。

如今的计算机内存，硬盘，CPU 都发展的非常强悍了，内存基本都是GB 级别，硬盘甚至还是 TB 级别的，所以在决定使用一个算法时，我们都会更加偏向于使用空间换时间的策略，即：牺牲一定的硬件资源来换取更快的运行速度。当然我们也要衡量该算法所占的硬件资源是否合理。

**表示：**S(n) = O(f(n))

**描述：**一个算法所占用的存储空间大小，与他的数据规模成正比

在开发过程中，我们更多的是考虑时间复杂度。

# 三. 排序算法

## 3.1 冒泡排序(Bubble Sort)

```java
package com.algorithm.demo03;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

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
        /**
         * 排序结果: [87, 76, 64, 53, 32, 15, 14, 8, 5, 1]
         */
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
```

**解析:** 冒泡排序的思想是, 从左至右, 将相邻的两个元素进行比较, 如果后一个数大于前一个数, 那么就相互调换位置。并重复这个过程，直到所有的元素都排列完。

## 3.2 选择排序(Selection Sort)

```java
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
        /**
          * 选择排序: [1, 3, 13, 32, 43, 43, 54, 65, 87, 89, 123]
          */
    }
}
```

**解析:** 选择排序的思想是每次遍历找到最小(最大)的数, 次小(次大)的数, 并将其从左至右进行排列

## 3.3 插入排序(Insertion Sort)

```java
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

```

## 3.4 希尔排序(Shell Sort)

```java
package com.algorithm.sort;


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
}

```



## 3.5 快速排序(Quick Sort)

## 3.6 归并排序(Merge Sort)

## 3.7 堆排序(Heap Sort)

```java
package com.algorithm.sort;

/**
 * @author: WuPeng
 * @description: 堆排序
 * @date: 2024/9/28 11:00
 */

public class HeapSort {

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
```



## 3.8 基数排序(Radix Sort)

# 四. **搜索算法**

## 4.1 线性搜索（Linear Search）

## 4.2  二分搜索（Binary Search）

## 4.3  深度优先搜索（Depth-First Search, DFS）

## 4.4  广度优先搜索（Breadth-First Search, BFS）

## 4.5 Dijkstra 算法（用于图的最短路径搜索）

## 4.6 A* 搜索算法（启发式搜索算法）

# 五. **图算法**

# 六. **动态规划**

# 七. **贪心算法**

# 八. **分治算法**

# 九. **数值算法**

# 十. **机器学习算法**

# 十一. **加密与安全算法**





1. **排序算法**：

- 冒泡排序（Bubble Sort）
- 选择排序（Selection Sort）
- 插入排序（Insertion Sort）
- 希尔排序（Shell Sort）
- 快速排序（Quick Sort）
- 归并排序（Merge Sort）
- 堆排序（Heap Sort）
- 基数排序（Radix Sort）

1. **搜索算法**：

- 线性搜索（Linear Search）
- 二分搜索（Binary Search）
- 深度优先搜索（Depth-First Search, DFS）
- 广度优先搜索（Breadth-First Search, BFS）
- Dijkstra 算法（用于图的最短路径搜索）
- A* 搜索算法（启发式搜索算法）

1. **图算法**：

- 最小生成树算法（如Prim算法、Kruskal算法）
- 拓扑排序（Topological Sort）
- 强连通分量算法（Kosaraju算法、Tarjan算法）
- 网络流算法（如Ford-Fulkerson算法、Edmonds-Karp算法）

1. **动态规划**：

- 背包问题
- 最长公共子序列（Longest Common Subsequence, LCS）
- 最长递增子序列（Longest Increasing Subsequence, LIS）
- 矩阵链乘法（Matrix Chain Multiplication）

1. **贪心算法**：

- 分数背包问题
- 区间调度问题
- 霍夫曼编码（Huffman Coding）

1. **分治算法**：

- 归并排序是一种典型的分治算法
- 快速排序也采用了分治策略
- 离散傅里叶变换（FFT）

1. **数值算法**：

- 牛顿法（Newton's Method）用于求解方程的根
- 梯度下降（Gradient Descent）用于优化问题
- 二分法（Bisection Method）用于求解方程的根

1. **机器学习算法**：

- K-均值（K-means）聚类算法
- 决策树（Decision Trees）
- 支持向量机（Support Vector Machines, SVM）
- 神经网络（Neural Networks）

1. **加密与安全算法**：

- RSA 加密算法
- AES 加密算法
- SHA 哈希函数系列

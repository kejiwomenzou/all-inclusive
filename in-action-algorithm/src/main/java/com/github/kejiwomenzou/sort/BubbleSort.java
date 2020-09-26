package com.github.kejiwomenzou.sort;

import java.util.Arrays;

import static com.github.kejiwomenzou.util.SortUtil.assertArr;
import static com.github.kejiwomenzou.util.SortUtil.compareTo;
import static com.github.kejiwomenzou.util.SortUtil.swap;

/**
 * @description: 冒泡排序
 * @auther: kejiwomenzou
 * @date: 2020/9/26
 * @version:
 */
public class BubbleSort {

    /**
     * 冒泡排序：时间复杂度：O(n^2)
     *         空间复杂度：O(1)
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

        assertArr(arr);
        //需要进行排序的次数，每执行一次排序比较交换出最大（最小）的数
        for (int i = 0; i < arr.length; i++) {

            //每次从数组第0个元素开始，选取两个元素两两比较，较大（或较小）的
            //数一直往后交换，直到最大（或最小）交换到数组末尾
            //每执行一次外层i循环，就会找出一趟中最大的数，内层两两比较次数就相应减少一次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (compareTo(arr[j], arr[j+1]) < 0) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    /**
     *  优化点1：用标记位判断每一趟排序是否整个两两交换过程都没有产生交换操作，从而避免已经有序了还进行多次遍历及比较
     *  优化点2：记录每次交换后最后停止的位置，停止之后的位置不需要比较，在某些情况下减少内层j的循环次数
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSortExtend(T[] arr) {

        assertArr(arr);
        boolean swapFlag = false;
        int lastSwapIndex = arr.length - 1;
        //只要产生交换就记录最后一次交换位置
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < lastSwapIndex; j++) {
                if (compareTo(arr[j], arr[j + 1]) > 0) {
                    swapFlag = true;
                    swap(j, j + 1, arr);
                    //最后交换到的位置
                    counter = j;
                }
            }
            lastSwapIndex = counter;
            //在当前这一趟比较下来没有交换元素，说明数组已经有序
            if (!swapFlag) {
                break;
            }
            swapFlag = false;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {9,4,10,23,1,-2,0,5};
        bubbleSortExtend(arr);
        System.out.println(Arrays.toString(arr));
    }
}

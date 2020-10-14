package com.github.kejiwomenzou;

import com.github.kejiwomenzou.util.SortUtil;

import java.util.Arrays;

/**
 * @description:
 * @auther: kejiwomenzou
 * @date: 2020/10/13
 * @version:
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {9,4,10,23,1,-2,0,5};
        //bubbleSort(arr);
        selectionSort(arr);
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        //优化点1：当有一趟中的所有两两比较都没有进行交换操作，说明整个数组已经有序
        boolean swap = true;
        //优化点2：如果数组中从左往右末尾已部分已经有序，那么从末尾有序部分不需要比较也不需要进行交换了
        //记录下末尾的起始位置
        int compareIndex = arr.length - 1;
        int counter = 0;
        //比较趟数
        for (int i = arr.length - 1; i > 0 ; i--) {

            //每一趟从左到右进行两两比较，满足条件则交换
            for (int j = 0; j < compareIndex ; j++) {
                if (arr[j] < arr[j+1]) {
                    SortUtil.swap(j, j+1, arr);
                    swap = false;
                    counter = j;
                }
            }
            compareIndex = counter;
            if (swap) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectionSort(int[] arr) {

        //从i=0开始共n-1轮，每一轮找出最大（小值）放在起始i位置
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    //找到并记录当前轮次中最值，记录到index
                    index = j;
                }
            }
            //将最值交换到起始位置
            if (index != i) {
                SortUtil.swap(index, i, arr);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

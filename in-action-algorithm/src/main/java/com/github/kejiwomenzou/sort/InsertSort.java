package com.github.kejiwomenzou.sort;

import static com.github.kejiwomenzou.util.SortUtil.*;

/**
 * @description: 插入排序: 类似于斗地主抓牌，手中的牌有序，抓进来的牌与手中的牌比较插入当合适的有序位置
 * @auther: kejiwomenzou
 * @date: 2020/10/13
 * @version:
 */
public class InsertSort {

    /**
     * 插入排序
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertSort(T[] arr) {

        assertArr(arr);
        T insertVal;
        int j;
        //n个数需要插入n-1次
        for (int i = 1; i < arr.length; i++) {
            //记录待插入元素
            insertVal = arr[i];
            //依次往后或往前移为待插入元素insertVal腾出位置
            for (j = i - 1; j >= 0 && compareTo(insertVal, arr[j]) > 0 ; j--) {
                arr[j + 1] = arr[j];
            }
            //将待插入元素
            arr[j + 1] = insertVal;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {101, 9,4,10,23,1,-2,0,5};
        insertSort(arr);
        printArr(arr);
    }
}

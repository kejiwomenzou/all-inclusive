package com.github.kejiwomenzou.sort;

import static com.github.kejiwomenzou.util.SortUtil.*;

/**
 * @description: 希尔排序：插入排序的增加版
 * @auther: kejiwomenzou
 * @date: 2020/10/14
 * @version:
 */
public class ShellSort {

    /**
     * 希尔排序：
     *      指定间隔对数组中处于间隔点的数进行一次插入排序
     *      然后缩小间隔再对数组中处于间隔点的数进行一次插入排序，
     *      依此类推，直到最后间隔为1进行一次普通的插入排序
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        assertArr(arr);
        //使用折中方法产生多次间隔
        for (int h = arr.length / 2; h > 0; h /= 2) {

            //间隔点往后推移
            for (int i = h; i < arr.length; i++) {

                //对指定符合当前间隔的数进行一次排序
                for (int j = i; j > h - 1; j -= h) {
                    if (compareTo(arr[j], arr[j - h]) < 0) {
                        swap(j, j - h, arr);
                    }
                }
            }
        }
    }

    /**
     * 希尔排序：使用Knuth序列产生间隔
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void shellSortByKnuth(T[] arr) {
        assertArr(arr);
        //knuth序列认为好的序列为： k = 1, k = k *3 + 1
        int k = 1;
        while (k <= arr.length / 3) {
            k = k * 3 + 1;
        }
        //折中产生多次间隔
        for (int h = k; h > 0; h = (h - 1)/3) {

            //间隔往后推移
            for (int i = h; i < arr.length; i++) {

                //对指定符合当前间隔的数进行一次排序
                for (int j = i; j > h - 1; j -= h) {
                    if (compareTo(arr[j], arr[j - h]) < 0) {
                        swap(j, j - h, arr);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        //shellSort(arr);
        shellSortByKnuth(arr);
        printArr(arr);
    }
}

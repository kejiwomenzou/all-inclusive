package com.github.kejiwomenzou.util;

import java.util.Arrays;

/**
 * @description:
 * @auther: kejiwomenzou
 * @date: 2020/9/26
 * @version:
 */
public class SortUtil {


    public static <T extends Comparable<T>> void assertArr(T[] arr) {
        assert null != arr && arr.length > 0;
    }

    /**
     * swap T[]
     * @param i
     * @param j
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void swap(int i, int j, T[] arr) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * compare method
     * @param obj1
     * @param obj2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int compareTo(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }

    /**
     * swap int[]
     * @param i
     * @param j
     * @param arr
     */
    public static void swap(int i, int j, int[] arr) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * print T[]
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void printArr(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

}

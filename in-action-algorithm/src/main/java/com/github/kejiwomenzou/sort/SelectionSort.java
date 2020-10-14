package com.github.kejiwomenzou.sort;

import com.github.kejiwomenzou.util.SortUtil;

import static com.github.kejiwomenzou.util.SortUtil.printArr;

/**
 * @description: 选择排序：
 *                  每次在未排序好的数组部分中从第一个元素开始寻找到数组末尾，找出一个未排序数组部分中
 *                  最大（小）的元素与当前元素交互位置，初始时整个数组认为都未排序好序，从第0个元素开
 *                  始往后找，找到后替换第0个元素为最大（小）值， 这样一共需要找arr.lenth-1次
 * @auther: kejiwomenzou
 * @date: 2020/9/26
 * @version:
 */
public class SelectionSort {

    /**
     * 选择排序：时间复杂度：O(n^2)
     *         空间复杂度：O(1)
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void selectSort(T[] arr) {
        SortUtil.assertArr(arr);
        //每遍历一次i, i会交换成数组排序好（从大到小或从小到大）的值，直到数组中最后一个值被排好序
        for (int i = 0; i < arr.length - 1; i++) {
            //记录当前遍历中数组中最大（小）的元素的下标，初始时认为第i个元素是比较的元素
            int index = i;
            //从第i+1个元素开始找到数组中最后一个元素，找出最大（小）的那个值的下标，并记录到index
            for (int j = i + 1; j < arr.length; j++) {
                if (SortUtil.compareTo(arr[index], arr[j]) > 0) {
                    index = j;
                }
            }
            //当前i下标元素交换成index下标对应的最大（小）值,
            //index还是i表示i就是剩余数组中最大（小）的那个
            if (index != i) {
                SortUtil.swap(index, i, arr);
            }
        }
    }

    public static void main(String[] args) {
        Character[] arr = {'c', 's', 'a', 'b','h', 'z', 'i'};
        selectSort(arr);
        printArr(arr);

        Integer[] arr2 = {12,345,1,23,4,50,0,89};
        selectSort(arr2);
        printArr(arr);
    }
}

package Algrorithm;

import SortMethod.SortTest;

/**
 * 荷兰国旗问题 ：
 * 目标数组 ： ->[小于 等于 大于]<-
 * 类似quickSort partition 过程
 * 左右分别划分 小于大于区域
 * 核心 ： 大于区域换回来的元素需要二次比较与截止条件 （指针i 在大于区域左边）
 */
public class NetherlandsFlag {
    public static void partition(int[] arr, int value){
        int left = -1;
        int right = arr.length;

        for (int i = 0; i < arr.length && i < right; ) {
            if (arr[i] < value){
                swapEle(arr, i++, ++left);
            }else if (arr[i] > value){
                swapEle(arr, i, --right);// 换回的大于元素，需要再进行一次比较
            }else {
                i++;
            }
        }
    }
    public static void swapEle(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

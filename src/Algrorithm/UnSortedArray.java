package Algrorithm;

import java.util.Arrays;

public class UnSortedArray {
    // 题目 ：返回数组中为最短未排序的数组
    // 思路 ：（不好想， 其实是寻找逆序对发生边界）从小到大遍历，遍历过部分的最大值大于当前遍历值 记录下最右边界
    // 从大到小遍历，遍历过部分的最小值小于当前遍历值 记录下最左边界
    public static int[] unSortedArray(int[] arr){

        int left = 0;
        int right = arr.length - 1;
        int max = arr[left];
        int min = arr[right];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max){
                right = i;
            }
            max = Math.max(max,arr[i]);
        }
        for (int i = arr.length - 1 ; i >=0 ; i--) {
            if (arr[i] > min){
                left = i;
            }
            min = Math.min(min,arr[i]);
        }
        //System.out.println( left + ":" + right);
        return Arrays.copyOfRange(arr,left,right+1);
    }

}

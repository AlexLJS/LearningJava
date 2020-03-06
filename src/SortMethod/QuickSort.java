package SortMethod;

public class QuickSort {
    /**
     * 快速排序 ：
     *  小于等于 选定数的 放左边 ，大于放右边 ， 递归
     *
     *  关键在于 切分方式有多种实现 ：
     *
     *  1、常规方式 :  双侧搜索
     *
     *  2、另一种思路 ： “构造小于等于区间”
     *  将划分值arr[special]放在数组最后 . [0,end] 建立<= 划分值的 小等于区间
     *  <= 划分值 ， 交换 end + 1  ， end+1 小等于区间 + 1
     *  > 跳过
     *  最后将尾部换至分界。
     *
     *
     */
    public static void quickSort(int[] arr){
        if (arr.length <= 1) return;
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (right <= left) return;

        int special = left +  (int) ( Math.random() * (right - left) );

        exch(arr, special, right);

        int end = left - 1;int index = left;//i : <= 区间尾索引  j : index
        for (; index < right ; index++){
            if (arr[index] > arr[right]){
            }else {
                exch(arr, ++end, index);
            }
        }
        exch(arr, end + 1 , right);
        quickSort(arr, left, end);
        quickSort(arr,end+2, right);
    }

    public static void exch(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

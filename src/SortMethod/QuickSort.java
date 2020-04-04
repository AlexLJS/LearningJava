package SortMethod;

public class QuickSort {
    /**
     * 快速排序 ：
     *  小于等于 选定数的 放左边 ，大于放右边 ， 递归
     *  （采用随机快排， 防止大体有序的情况快排蜕化为 n^2 , 左右部分规模相差太大）
     *  （规避样本数据状况的另一种方式 ： 哈希函数）
     *  关键在于 切分方式有多种实现 ：
     *
     *  1、常规方式 :  双侧搜索
     *
     *  2、另一种思路 ： “构造小于等于区间”  经典随机快排
     *  将划分值arr[special]放在数组最后 . [0,end] 建立<= 划分值的 小等于区间
     *  <= 划分值 ， 交换 end + 1  ， end+1 小等于区间 + 1
     *  > 跳过
     *  最后将尾部换至分界。
     *
     * 3、荷兰国旗对于快排的改进 ，等于区域不用改动：
     * 尝试返回下标索引（数组），改进快排代码， 等于区域不做改动
     * new int[]{left, right}
     *
     * 注：
     * 1、随机快排的额外空间复杂度 O(logN) 浪费在记录断点位置
     * 2、胜过归并排序两点 ： 空间复杂度， 常数项比较少
     * 3、工程上不允许使用递归
     *
     * 4、0-1 stable sort  论文级别的稳定快排
     */
    public static void quickSort(int[] arr){
        if (arr.length <= 1) return;
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (right <= left) return;

        int special = left +  (int) ( Math.random() * (right - left) );//空间浪费位置

        exch(arr, special, right);

        int end = left - 1;int index = left;//i : <= 区间尾索引  j : index
        for (; index < right ; index++){
            if (arr[index] <= arr[right]){
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

package SortMethod;

import java.util.Arrays;

public class MergeSort {
    /**
     * 归并排序 ：
     * 归并排序体现分治思想 ， 可以用数学归纳法进行证明 时间复杂度 O(NlogN)  空间复杂度 N
     * “2个有序，推4个有序， 推8个有序…”
     * 分为两个过程 ： 拆分 ， 合并  （多称为 sort merge）
     * 思路 ：不断拆分 ， 复制辅助数组再有序放回原数组
     *
     * 二路归并：
     * 自顶而下的二路归并：由长到短
     * 自底而上的二路归并：由短到长
     *
     * 性能：数据量小的话因为递归调用，性能不如插入排序
     * 优化：有序性校验 ， 小规模使用插入排序，优化辅助数组
     *
     * 拓展 ： 多路归并
     * */
    // 自顶而下的二路归并
    public static void sortA(int[] arr){
        int[] assist = new int[arr.length];
        sortA(arr,0,arr.length - 1, assist);
    }

    public static void sortA(int[] arr, int low, int high, int[] assist){
        if (low >= high) return;//出口

        int mid = low + (high - low)/2;
        sortA(arr, low, mid, assist);
        sortA(arr,mid+1, high,assist);
        mergeA(arr, low, high, mid, assist);
    }

    // [...low ...mid mid+1... high...] merge [low,high]
    public static void mergeA(int[] arr, int low, int high, int mid, int[] assist){
        int i = low;
        int j = mid + 1;
        assist = Arrays.copyOf(arr,arr.length);
//        for (int k = low ; k <= high ; k++) {
//            assist[k] = arr[k];
//        }
        //先处理越界情况
        for (int k = low; k <= high ; k++) {
            if (i > mid){
                arr[k] = assist[j++];
            }else if (j > high){
                arr[k] = assist[i++];
            }else if (assist[i] < assist[j]){
                arr[k] = assist[i++];
            }else {
                arr[k] = assist[j++];
            }
        }
    }

    //自底而上的二路归并
    public static void sortB(int[] arr){
        int len = arr.length;
        int[] assist = new int[len];
        for (int i = 1; i < len; i = i*2) {
            // 剩下元素 超过1倍步长， 则可再进行一次 merge
            for (int j = 0; j < len-i; j = j+i*2 ) {
                //i ：步长  ， j  ：low指针
                mergeA(arr, j, Math.min( j+2*i-1, len-1), j+i-1, assist);
            }
        }
    }

}

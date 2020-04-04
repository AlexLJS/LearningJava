package SortMethod;

public class HeapSort {
    /**
     * 堆排序：（优先队列 ，完全二叉树）
     *
     * 代码量小，却比较复杂 ： 大顶堆、小顶堆、向上调整swim、向下调整sink……
     *（大顶堆 ： 完全二叉树中，任何一棵子树的最大值都是父节点）
     * 参考《算法4》，大顶堆反向向下调整的 堆排序。
     * root节点从1开始 (补了头节点) ， 即父节点 k  左孩子 2k  右孩子 2k+1
     *
     * 思路：
     * 调整数组构成一个大顶堆，交换顶与最后一个节点。在将最后一个节点排除在外，重复调整大顶堆。
     * 从第一个非叶子节点开始 ， 排查是否存在子节点比它值大，进行交换。 直到检查到根节点。
     *
     * 主流思路2：
     * heapinsert ：节点插入有序堆 向上过程
     * heapify ：某节点值发生改变 （变小），向下过程
     *
     *
     */

    public static void heapSort(int[] arr){
        if (arr.length <= 1) return;
        int len = arr.length;
        int[] array = new int[len+1];
        System.arraycopy(arr,0,array,1,len);

        //第一个非叶子节点
        for (int i = len/2 ; i >= 1 ; i--) {
            adjust(array,i,len);
        }
        while (len > 1){
            swap(array,1,len--);
            adjust(array,1,len);
        }

        System.arraycopy(array,1,arr,0,arr.length);
    }

    private static void adjust(int[] arr, int start, int len){
        while (2*start <= len ){
            int left = 2*start;
            if (left < len && arr[left] < arr[left+1])
                left++;//右孩子 比较大  ， 索引指向右孩子
            if (arr[start] >= arr[left])
                break;//不需要交换情况 , 父节点比较大
            swap(arr,start,left);
            start = left;
        }
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

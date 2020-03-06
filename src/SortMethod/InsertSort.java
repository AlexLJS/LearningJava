package SortMethod;

public class InsertSort {
    //插入排序 ： 维持一个有序序列
    public static void insertSort(int[] arr){
        if (arr.length <= 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
               if (arr[j] < arr[j-1]){
                   int temp = arr[j];
                   arr[j] = arr[j-1];
                   arr[j-1] = temp;
               }
            }
        }
    }
}

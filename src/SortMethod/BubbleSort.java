package SortMethod;

public class BubbleSort {
    //冒泡排序
    public static void bubbleSort(int[] arr){
        if (arr.length <= 1) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++){
               if (arr[j] < arr[j-1]){
                   int temp = arr[j];
                   arr[j] = arr[j-1];
                   arr[j-1] = temp;
               }
           }
        }
    }
}

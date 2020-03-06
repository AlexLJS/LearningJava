package SortMethod;

public class SelectSort {
    //选择排序 ： 与冒泡区别是 冒泡是相邻两者之间比较 ， 选择是范围之间的最值
    public static void selectSort(int[] arr){
        if (arr.length <= 1) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

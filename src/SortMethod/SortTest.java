package SortMethod;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] testArr = {6,0,3,4,7,2,5,8,2,1};
        //printArr(testArr);
        //BubbleSort.bubbleSort(testArr);
        //InsertSort.insertSort(testArr);
        //MergeSort.sortB(testArr);
        //printArr(testArr);
        //QuickSort.quickSort(testArr);
        printArr(testArr);
    }
    // print array
    public static void printArr(int[] arr){
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.print("}");
        System.out.println();
    }
}

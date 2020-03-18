package Algrorithm;

public class SortColors {
    //荷兰国旗 leetcode 75
    public static void sortColors(int[] nums){
        int left = -1;
        int right = nums.length;

        for (int index = 0; index < nums.length; index++) {
            if (index == right)
                break;
            if (nums[index] == 0) {
                swap( nums, ++left, index);
            }
            if (nums[index] == 2) {
                //关键  index--  末尾换回来的元素，没有经过检验
                swap( nums, --right, index--);
            }
        }

    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

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

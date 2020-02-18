package Algrorithm;

public class ProductExceptSelf {
    // leet code  238  思路 左右数组
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 0; i < len ; i++) {
            if (i == 0) {
                left[0] = 1;
            }else {
                left[i] = left[i-1] * nums[i-1];
            }
        }
        for (int j = len-1; j >= 0 ; j--) {
            if (j == len-1){
                right[j] = 1;
            }else {
                right[j] = right[j+1] * nums[j+1];
            }
            res[j] = left[j]*right[j];
        }
        return res;
    }
}

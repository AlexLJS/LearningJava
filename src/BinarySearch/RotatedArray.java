package BinarySearch;

public class RotatedArray {
    // 旋转排序数组，查找 元素
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = left + ((right - left) >> 1);

        while (left <= right){
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] >= nums[left]){
                if (target >= nums[left] && target < nums[index]){
                    right = index - 1;
                }else {
                    left = index + 1;
                }
            }else {
                if (target > nums[index] && target <= nums[right]){
                    left = index + 1;
                }else {
                    right = index - 1;
                }
            }
            index = left + ((right - left) >> 1);
        }
        return -1;
    }
}

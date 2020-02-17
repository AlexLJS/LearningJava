package Tencent50;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aim =(int)Math.ceil((double) (nums1.length + nums2.length) / 2 );
        int left = findNum(nums1,nums2,aim);
        int right = 0;
        right = (nums1.length + nums2.length) % 2 == 1 ? left : findNum(nums1,nums2,aim+1);
        return  (double)(left + right)/2 ;
    }
    public static int findNum(int[] nums1, int[] nums2, int aim){
        int x = 0; int y = 0;
        int min = 0;
        for ( int index = 0; index < aim; index++){
            if (x < nums1.length && y < nums2.length) {
                min = nums1[x] < nums2[y] ? nums1[x++]:nums2[y++];
            }else if ( x >= nums1.length ){//num1 max length
                min = nums2[y++];
            }else if ( y >= nums2.length ){
                min = nums1[x++];
            }
        }
        return min;
    }
}

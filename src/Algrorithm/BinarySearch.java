package Algrorithm;

public class BinarySearch {
    //Recursive
    public static int bSearch1(int[] arr, int value){
        return bSearchInternally(arr, 0, arr.length - 1, value);
    }

    public static int bSearchInternally(int[] arr, int low, int high, int value){
        if (low > high)
            return -1;

        int mid = (low + high)/2;//low + ((high - low)>>1)
        if (arr[mid] == value) {
            return mid;
        }else if (arr[mid] > value) {
            return bSearchInternally(arr, low, mid - 1, value);
        }else {
            return bSearchInternally(arr, mid + 1, high, value);
        }
    }
    //Not recursive
    public static int bSearch2(int[] arr, int value){
        int high = arr.length - 1;
        int low = 0;
        int index = low + ((high - low)>>1);

        while (low <= high){
            if (arr[index] == value){
                return index;
            }else if (arr[index] < value){
                low = index + 1;
            }else {
                high = index - 1;
            }
            index = low + ((high - low)>>1);
        }
        return -1;
    }
    // return FirstIndex
    public static int bSearch3(int[] arr, int value){
        return bS3Internally(arr,0,arr.length - 1,value);
    }
    public static int bS3Internally(int[] arr, int low, int high, int val){
        if (low > high)
            return -1;

        int mid = low + ((high - low)>>1);
        if (arr[mid] < val){
            return bS3Internally(arr, mid + 1, high, val);
        }else if (arr[mid] > val){
            return bS3Internally(arr, low, mid - 1, val);
        }else {
            if (mid == 0 || arr[mid - 1] != val){
                return mid;
            }else {
                return bS3Internally(arr, low, mid - 1, val);
            }
        }
    }
}

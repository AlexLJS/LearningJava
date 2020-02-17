package Tencent50;

public class IsPalindrome {
    /**
     * 题目9 回文数
     */
    public static boolean myAnswer(int input){
        char[] chars =  String.valueOf(input).toCharArray();

        int left  = 0;
        int right = chars.length - 1;

        while (right >= 0 && left <= chars.length - 1){
            if (chars[right] == chars[left]){
                right--;
                left++;
            }else {
                return false;
            }
            if (right < left) {
                return true;
            }
        }
        return false;
    }
}

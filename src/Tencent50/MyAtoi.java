package Tencent50;

public class MyAtoi {


    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        if (chars.length == 0) return 0;//非法输入
        String res = "";
        int sign = 1;//符号
        int headIndex = 0;//output下标
        while(headIndex < chars.length){//找到开头
            if (chars[headIndex] != ' ') break;
            headIndex++;
        }
        if ( headIndex < chars.length && (chars[headIndex] == '+' || chars[headIndex] == '-' )) {//check符号
            sign = chars[headIndex] == '+' ? 1: -1;
            headIndex++;
        }
        while ( headIndex < chars.length && chars[headIndex] <= '9' && chars[headIndex] >= '0') {//数字
            res = res.concat(String.valueOf(chars[headIndex++]));
        }
        while (res.length() != 0 && res.charAt(0) == '0'){// 去除数字0开头
            res = res.substring(1);
        }
        if (sign == 1 && res.length() > 0){
            return res.length() < 11 && Long.valueOf(res) <= Integer.MAX_VALUE ? Integer.valueOf(res) : Integer.MAX_VALUE;
        }else if (sign == -1 && res.length() > 0){
            return res.length() < 11 && -Long.valueOf(res) > (long)-2147483648 ? Integer.valueOf(res) * (-1) : Integer.MIN_VALUE;
        }
        return 0;
    }
}

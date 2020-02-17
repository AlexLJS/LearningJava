package Tencent50;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        n = Math.abs(n);
        if ( n == 1 ) return true;
        if ( n == 0 ) return true;
        return judge(n);
    }
    public static boolean judge(int n){
        if (n == 2) return true;
        if (n % 2 == 1) return false;
        return judge(n/2);
    }
}

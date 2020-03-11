package Algrorithm;

public class Gcd {
    //最大公约数 ： 欧几里得算法
    public static int gcd(int a, int b){
        if (b == 0) return b;
        int s = a%b;
        return gcd(b,s);
    }
}

package JavaFeatures;

public class SomeBasics {
    public static void main(String[] args) {
        System.out.println(2.0e-6 * 100000000.1); //200.0000002
        System.out.println((1 + 2.236)/2);//1.168
        System.out.println(1 + 2 + "3");//33

        System.out.println(true && false || true && true);//true

        System.out.println(judgeDouble(1.2));
        System.out.println(bString(123));

        //斐波那契数列
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f += g;
            g = f - g;
        }

        //char
        System.out.println('b'); // b
        System.out.println('b' + 'c'); // 197
        System.out.println((char)('a'+4));//e


    }
    //严格判断 double 类型变量范围 (0,1)
    public static boolean judgeDouble(double a){
        if (a > 0.0 && a < 1.0) return true;
        return false;
    }
    //Integer.toBinaryString(N) 的实践
    public static String bString(int n){
        String s = "";
        for (int i = n; i > 0 ; i /= 2) {
            s = (i % 2) + s;
        }
        return s;
    }


}

package MatrixAndArray;

/**
 * "之"字型打印：
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * out ： 1 2 4 7 5 3 6 8 9
 * 思路：
 * 1、左神通用打印思路:
 * 非常清晰， 两个指针均从（0，0）出发，分别沿着横、纵前进，连线就是路径。boolean控制方向。
 * 代码简洁优雅，使用形参解决掉了游标移动问题（否则例如从上到下，cur会停在下方，需要变换方向）
 * 2、我的算法：
 * 我观察了下标，每一个之字路径的和是连续整数，利用这点找到一个下标的变化规律。
 * 在一个while死循环里，让下标实现来回翻折，找准下标边界变化条件，妙啊！
 * （真是弟弟算法，调了太多遍，哎，不具备普适性，垃圾）
 * 注：
 * 两个idea快捷键：
 * 光标在那行，ctr + c ：直接复制本行
 * shift + 左键 ：选中与光标之间的部分（非常好用）
 */
public class ZigZagPrint {
    public void printMatrixZigZag(int[][] m){
        int curY = 0;
        int curX = 0;//起记录作用，cur边界移动时使用
        int len = 0;
        boolean flag = true;//false cur向左下方移动  true cur向右下方
        int lenMax = m.length + m[0].length - 1;//（0，0）-（m-1，n-1），边界m+n-1

        while (len < lenMax){
            curX = len - curY;
            System.out.print(m[curX][curY] + " ");
            if (flag){//向右上滑动
                if (curY == m[0].length-1 || curX == 0) {//换方向条件
                    len++;
                    flag = false;
                }
                if (len - curY > 0 && curY < m[0].length-1){
                    curY++;//不换方向cur的移动要排除边界
                }
                if (curY == m[0].length-1){//右边界
                    curX++;
                }
            }else {
                if (curY == 0 || curX == m.length-1) {
                    len++;
                    flag = true;
                }
                if (curY > 0 && len - curY < m.length-1){
                    curY--;
                }
                if (curX == m.length - 1){//底边
                    curY++;
                }
            }
        }
        System.out.println();
    }

    public void printPro(int[][] m){
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = m.length - 1;
        int endC = m[0].length -1;
        boolean fromUp = false;
        while (tR != endR + 1){
            printLevel(m, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public void printLevel(int[][] m, int tR, int tC,
                           int dR, int dC, boolean fromUp){
        if (fromUp){
            while (tR != dR + 1){
                System.out.print(m[tR++][tC--] + " ");
            }
        }else {
            while (dR != tR - 1){
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }
}

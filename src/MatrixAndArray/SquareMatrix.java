package MatrixAndArray;

/**
 * 讨论一下方阵的问题：
 * 方阵由于特殊的对对称性适合，可以用多种方法解决问题。
 * 问题：
 * 1、顺时针旋转90度。空间O（1）
 * 首先想到的是，利用轴对称和主对角线对称，两次变换。
 * 代码简单，颠倒变换顺序，可以实现逆时针。
 * 2、书中给出分层分组旋转。
 * 每层中，旋转形成循环的四个节点，组成一组。（例如四个角）
 * 代码短，复用性好。
 */
public class SquareMatrix {
    public void rotate1(int[][] m){
        mainDiagonalLine(m);
        symmetry(m);
    }
    public void rotate2(int[][] m){
        int tR = 0;
        int tC = 0;
        int dR = m.length - 1;
        int dC = m[0].length - 1;

        while (tR <= dR && tC <= dC){
            rotateEdge(m , tR++ , tC++ , dR-- , dC--);
        }
    }
    private void rotateEdge(int[][] m, int tR, int tC, int dR, int dC){
        int temp;
        for (int i = 0; i < dC - tC; i++){
            temp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = temp;
        }
    }
    //轴对称
    private static void symmetry(int[][] m){
        int curL;
        int curH;
        int temp;
        for (int x = 0; x < m.length; x++){
            curL = 0;
            curH = m[x].length - 1;
            while (curL < curH){
                temp = m[x][curL];
                m[x][curL] = m[x][curH];
                m[x][curH] = temp;
                curL++;
                curH--;
            }
        }
    }
    //主对角线对称
    private static void mainDiagonalLine(int[][] m){
        int temp;
        for (int x = 0; x < m.length; x++){
            for (int y = 0 ; y < x; y++){
                temp = m[x][y];
                m[x][y] = m[y][x];
                m[y][x] = temp;
            }
        }
    }
}

package MatrixAndArray;

/**
 * 题目：旋转打印一个矩阵
 * 要求：空间复杂度O(1)
 * 思路：
 * 我可能会去计算转折点下标与N的关系，着实有些愚蠢。
 * 附上左神思路代码，按照圈层打印，从主对角线两端逐渐向内，
 * 一圈一圈打印。
 *
 * 注意： 矩阵可能不是一个方阵， 会存在子矩阵只有一行或者一列的情况。
 */
public class SprialOrderPrint {
    public void sprialOrderPrint(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC){
            printEdge(matrix , tR++ , tC++ , dR-- , dC-- );
        }
    }
    public void printEdge(int[][] matrix , int tR , int tC , int dR , int dC){
        if (tR == dR){
            for (int i = tC; i <= dC; i++)
                System.out.print(matrix[tR][i] + " ");
        }else if (tC == dC){
            for (int i = tR; i <= dR; i++)
                System.out.print(matrix[i][tC] + " ");
        }else {
            int x = tR;
            int y = tC;
            while (y != dC)
                System.out.print(matrix[x][y++] + " ");
            while (x != dR)
                System.out.print(matrix[x++][y] + " ");
            while (y != tC)
                System.out.print(matrix[x][y--] + " ");
            while (x != tR)
                System.out.print(matrix[x--][y] + " ");
        }
    }
}

package MatrixAndArray;

public class FindNumInSortedMat {
    /**
     * 排序矩阵中查找元素（行列分别有序，从小到大）
     * 1 3 6 7
     * 4 5 8 9
     * 6 9 11 12
     * 8 10 15 17
     *
     * 核心： 从右上角开始找(或者从左下角找，略)
     */
    public boolean find(int[][] mat, int aim){
        int x = 0;
        int y = mat[x].length - 1;
        while (x < mat.length && y >= 0){
            if (mat[x][y] == aim) {
                return true;
            }else if (mat[x][y] > aim){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}

package Utils;


public class MatrixUtil {
    //顺序方阵
    public int[][] getOrderMatrix(int dim){
        int[][] newMatrix = new int[dim][dim];
        int value = 1;
        for (int x = 0 ; x < dim ; x++){
            for (int y = 0 ; y < dim ; y++){
                newMatrix[x][y] = value++;
            }
        }
        return newMatrix;
    }
    //随机方阵，随机范围20
    public int[][] getRandomMatrix(int dim){
        int[][] randomMatrix = new int[dim][dim];
        int scope = 20;
        for (int x = 0 ; x < dim ; x++){
            for (int y = 0 ; y < dim ; y++){
                randomMatrix[x][y] = (int)(Math.random() * scope);
            }
        }
        return randomMatrix;
    }
    //任意随机矩阵自定义范围
    public int[][] randomMatrix(int i , int j ,int scope){
        int[][] randomMatrix = new int[i][j];

        for (int x = 0 ; x < i ; x++){
            for (int y = 0 ; y < j ; y++){
                randomMatrix[x][y] = (int)(Math.random() * scope);
            }
        }
        return randomMatrix;
    }
    //显示矩阵
    public void printMatrix(int[][] mat){
        for (int x = 0 ; x < mat.length ; x++){
            for (int y = 0 ; y < mat[x].length ; y++){
                System.out.print(mat[x][y] + " ");
            }
            System.out.println();
        }
    }
}

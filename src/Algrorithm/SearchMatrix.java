package Algrorithm;

public class SearchMatrix {
    //leetcode 74  :  时间复杂度要求 O(M + N )

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <=  0) return false;
        int y = matrix.length - 1;
        int x =  0;

        while (y >= 0 && x < matrix[0].length){
            if (matrix[y][x] == target){
                return true;
            }else if (matrix[y][x] < target ){
                x++;
            }else {
                y--;
            }
        }
        return false;
    }



}

package array;

import org.junit.Test;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int[][] ans = new int[rows][cols];
        for(int i =0; i < rows; i++){
            int[] A_row = A[i];
            for(int j = 0; j < cols; j++){
                int result = 0;
                for(int k =0; k < A_row.length; k++){
                    result += A_row[k] * B[k][j];
                }
                ans[i][j] = result;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int [][] A = new int[][]{{1, 0, 0}, {-1, 0, 3}};
        int[][] B = new int[][]{{7, 0, 0 }, {0, 0, 0 }, {0, 0, 1}};
        int[][] ans = multiply(A, B);
    }
}

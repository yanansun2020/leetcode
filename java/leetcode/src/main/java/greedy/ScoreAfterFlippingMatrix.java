package greedy;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        int numRows = A.length;
        int numCols = A[0].length;
        for(int i = 0; i <numRows; i++) {
            if (A[i][0] == 0) {
                flipRow(i, A);
            }
        }
        for (int col = 0; col < numCols; col++) {
            int sum = 0;
            for (int row = 0; row < numRows; row++) {
                sum += A[row][col];
            }
            if (sum < numRows - sum) {
                flipCol(col, A);
            }
        }
        int total = 0;
        for (int i = 0; i < numRows; i++) {
            total += toTenBased(A[i]);
        }
        return total;
    }
    private void flipRow(int rowIndex, int[][] A){
        for (int i = 0; i < A[rowIndex].length; i++) {
            A[rowIndex][i] ^= 1;
        }
    }
    private void flipCol(int colIndex, int[][] A){
        for (int i = 0; i < A.length; i++) {
            A[i][colIndex] ^= 1;
        }
    }
    private int toTenBased(int[] A){
        int length = A.length - 1;
        int res = 0;
        for (int i = 0; i <= length; i++) {
            res += A[i] * (1 << (length - i));
        }
        return res;
    }
}

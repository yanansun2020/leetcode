package algorithm.tree;

public class FenwickTree2D {
//    private int rows; // number of rows in the matrix
//    private int cols; // number of colums in the matrix
//    int matrix[][];
//    int bit[][];
//
//    private void buildBIT() {
//        for (int i = 1; i <= rows; ++i) {
//            for (int j = 1; j <= cols; ++j) {
//                // call update function on each of the entries present in the matrix
//                int val = this.matrix[i][j];
//                updateBIT(i, j, val);
//            }
//        }
//    }
//    private void updateBIT(int r, int c, int val) {
//        // keep adding lsb(i) to i, lsb(j) to j and add val to bit[i][j]
//        // Using two nested for loops, one for the rows and one for the columns
//        for (int i = r; i <= rows; i += lsb(i)) {
//            for (int j = c; j <= cols; j += lsb(j)) {
//                this.bit[i][j] += val;
//            }
//        }
//    }
//
//    private int queryBIT(int r, int c) {
//        int sum = 0;
//        // keep subtracting lsb(i) to i, lsb(j) to j and obtain the final sum as the sum of non-overlapping sub-rectangles
//        // Using two nested for loops, one for the rows and one for the columns
//        for (int i = r; i > 0; i -= lsb(i)) {
//            for (int j = c; j > 0; j -= lsb(j)) {
//                sum += this.bit[i][j];
//            }
//        }
//        return sum;
//    }
}

package backtracking;

import org.junit.Test;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }
    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(i, j, board, num)) {
                        board[i][j] = num;
                        if (dfs(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char[][] board, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
            int m = 3 * (row/3) + i/3;
            int n = 3 * (col/3) + i%3;
            if (board[m][n] == num) {
                return false;
            }
        }
        return true;

    }
    @Test
    public void test() {
        char[][] c = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(c);
    }

}

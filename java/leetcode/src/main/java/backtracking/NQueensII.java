package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    public int totalNQueens(int n) {
        List<Integer> cols = new ArrayList<>();
        List<Integer> diag1 = new ArrayList<>();
        List<Integer> diag2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        return dfs(0, n, diag1, diag2, cols, res);
    }
    int dfs(int row, int n, List<Integer> diag1, List<Integer> diag2, List<Integer> cols, List<Integer> res){
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isAvailable(diag1, diag2, cols, row, i)) {
                int index1 = row + i;
                int index2 = row - i;
                res.add(i);
                diag1.add(index1);
                diag2.add(index2);
                cols.add(i);
                count += dfs(row + 1, n, diag1, diag2, cols, res);
                res.remove(res.size() - 1);
                diag1.remove(diag1.size() - 1);
                diag2.remove(diag2.size() - 1);
                cols.remove(cols.size() - 1);
            }
        }
        return count;
    }
    private boolean isAvailable(List<Integer> diag1, List<Integer> diag2, List<Integer> cols, int row, int col){
        if (diag1.contains(row + col) || diag2.contains(row - col) || cols.contains(col)){
            return false;
        }
        return true;
    }
    private List<String> convertToString(List<Integer> positions, int n){
        List<String> queens = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            int pos_q = positions.get(j);
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (k != pos_q) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            queens.add(sb.toString());
            j++;
        }
        return queens;
    }
}

package oa.gg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.1point3acres.com/bbs/thread-795024-1-1.html
 * 1. 印男面试官：给一个矩阵，由0和H组成，0表示空地，H表示房子，房子四周可以种花，要求每一行每一列都最多种一朵花。要求输出所有可能方案。DFS backtracking
 */
public class PlantFlower {
    public List<List<String>> plantFlower(int[][] house) {
        if (house == null || house.length == 0 || house[0].length == 0) {
            return new ArrayList<>();
        }
        int[][] plantPosition = getPositions(house);
        LinkedList<Integer> rows = new LinkedList<>();
        LinkedList<Integer> cols = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        int n = house[0].length;
        dfs(0, n, plantPosition, rows, cols, res);
        return res;
    }

    private void dfs(int row, int n, int[][] plantPosition, LinkedList<Integer> rows, LinkedList<Integer> cols, List<List<String>> res) {
        if (row == plantPosition.length) {
            List<String> flowers = getFlowers(plantPosition.length, n, rows, cols);
            res.add(flowers);
            return;

        }
        for (int i = 0; i < n; i++) {
            if (canPlant(row, i, plantPosition, rows, cols)) {
                //select1. plant a flower on (row, col)
                cols.add(i);
                rows.add(row);
                dfs(row + 1, n, plantPosition, rows, cols, res);
                cols.removeLast();
                rows.removeLast();
                //select2. not plant flower on (row, col)
                dfs(row + 1,  n, plantPosition, rows, cols, res);

            }
        }
    }

    private List<String> getFlowers(int totalRow, int totalCol, List<Integer> rows, List<Integer> cols) {
        int[][] flowers = new int[totalRow][totalCol];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            int r = rows.get(i);
            int c = cols.get(i);
            flowers[r][c] = 1;
        }
        for (int i = 0; i < totalRow; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < totalCol; j++) {
                if (flowers[i][j] == 1) {
                    sb.append("F");
                }else {
                   sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    private boolean canPlant(int row, int col, int[][] pos, LinkedList<Integer> rows, LinkedList<Integer> cols) {
        if (pos[row][col] == 1 && !rows.contains(row) && !cols.contains(col)) {
            return true;
        }
        return false;
    }

    private int[][] getPositions(int[][] house) {
        int row = house.length;
        int col = house[0].length;
        int[][] pos = new int[row][col];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (house[i][j] == 0) {
                    continue;
                }
                for (int[] dir : dirs) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];
                    if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && house[newRow][newCol] == 0) {
                        pos[newRow][newCol] = 1;
                    }
                }
            }
        }
        return pos;
    }

    @Test
    public void test() {
        int[][] house = new int[][]{{0, 1}, {0, 0}};
        List<List<String>> flowers =  plantFlower(house);
    }
}

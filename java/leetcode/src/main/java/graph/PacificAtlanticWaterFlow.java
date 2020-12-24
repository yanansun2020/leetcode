package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * think in reversed order, water can go from oceans to higher place
 * Start from border, for each point, do dfs
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] reachableToP = new int[rows][cols];
        int[][] reachableToA = new int[rows][cols];
        int[][] visited = new int[rows][cols];
        init_border(rows, cols, reachableToP, reachableToA);
        for (int i = 0; i < cols; i++) {
            dfs(new int[]{0, i}, matrix, reachableToP, visited);
        }
        for (int i = 0; i < rows; i++) {
            dfs(new int[]{i, 0}, matrix, reachableToP, visited);
        }
        visited = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            dfs(new int[]{rows - 1, i}, matrix, reachableToA, visited);
        }
        for (int i = 0; i < rows; i++) {
            dfs(new int[]{i, cols - 1}, matrix, reachableToA, visited);
        }
//        init_border(rows, cols, reachableToP, reachableToA);
//        dfs(new int[]{0, 0}, matrix, reachableToP, visited);
//        visited = new int[rows][cols];
//        bfs(new int[]{rows - 1, cols -1}, matrix, reachableToA, visited);
        for (int i = 0; i < rows; i++ ) {
            for (int j = 0; j < cols; j++) {
                if (reachableToA[i][j] == 1 && reachableToP[i][j] == 1) {
                    List<Integer> tmp = Arrays.asList(i, j);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }

    void dfs(int[] coordinate, int[][] matrix, int[][] reachableMatrix, int[][] visited){
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = coordinate[0];
        int col = coordinate[1];
        visited[row][col] = 1;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length) {
                continue;
            }
            if (visited[newRow][newCol] == 1) {
                continue;
            }
            if (matrix[newRow][newCol] >= matrix[row][col] || reachableMatrix[newRow][newCol] == 1) {
                reachableMatrix[newRow][newCol] = 1;
                dfs(new int[]{newRow, newCol}, matrix, reachableMatrix, visited);
            }
        }
    }

    void bfs(int[] coordinate, int[][] matrix, int[][] reachableMatrix, int[][] visited){
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(coordinate);
        while (!queue.isEmpty()) {
            int[] ele = queue.poll();
            int row = ele[0];
            int col = ele[1];
            visited[row][col] = 1;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length) {
                    continue;
                }
                if (visited[newRow][newCol] == 1) {
                    continue;
                }
                int preReachable = reachableMatrix[row][col];
                if (preReachable > 0 && reachableMatrix[newRow][newCol] == 0 && matrix[newRow][newCol] >= matrix[row][col]) {
                    reachableMatrix[newRow][newCol] = 1;
                }
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
    private void init_border(int rows, int cols, int[][] reachableToP, int[][] reachableToA){
        for (int i = 0; i < cols; i++) {
            reachableToP[0][i] = 1;
        }
        for (int i = 0; i < rows; i++) {
            reachableToP[i][0] = 1;
        }
        for (int i = 0; i < cols; i++) {
            reachableToA[rows - 1][i] = 1;
        }
        for (int i = 0; i < rows; i++) {
            reachableToA[i][cols - 1] = 1;
        }
    }
    @Test
    public void test(){
        int[][] matrix = new int[][]{{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
        matrix = new int[][]{{1,2,3}, {8,9,4}, {7,6,5}};
        List<List<Integer>> res = pacificAtlantic(matrix);
    }
}

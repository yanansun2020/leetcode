package oa.amazon.ftoa;

import org.junit.Test;

/**
 * dfs model
 */
public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int areaOneIsland = dfs(i, j, grid, visited);
                    maxArea = Math.max(maxArea, areaOneIsland);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid, int[][] visited) {
        if (!isValid(i, j , grid, visited)) {
            return 0;
        }
        visited[i][j] = 1;
        int island = 1;
        island += dfs(i - 1, j, grid, visited);
        island += dfs(i + 1, j, grid, visited);
        island += dfs(i, j - 1, grid, visited);
        island += dfs(i, j + 1, grid, visited);
        return island;
    }

    private boolean isValid(int i, int j, int[][] grid, int[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;
        if (i < 0 || i > rows - 1 || j < 0 || j > cols -1) {
            return false;
        }
        if (visited[i][j] == 1) {
            return false;
        }
        if (grid[i][j] == 0) {
            return false;
        }
        return true;
    }

    @Test
    public void test(){
        int[][] nums = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int ans = maxAreaOfIsland(nums);
    }
}

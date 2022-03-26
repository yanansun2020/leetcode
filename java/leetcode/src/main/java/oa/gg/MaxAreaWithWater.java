package oa.gg;

import org.junit.Test;

/**
 * leetcode 695的变形，被陆地围起来的水也算作陆地面积。依然是DFS。
 * 695 + 1254
 * 0-water 1-island
 * idea: start from the four edges, if come across water, dfs to mark all waters.
 * Then cells left can be considered island
 *
 */
public class MaxAreaWithWater {
    public int maxAreaOfClosedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        //mark all water
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                markWater(0, i, grid);
            }
            if (grid[row - 1][i] == 0) {
                markWater(row - 1, i, grid);
            }
        }

        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 0) {
                markWater(i, 0, grid);
            }
            if (grid[i][col - 1] == 0) {
                markWater(i, col - 1, grid);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) {
                    int area = getArea(i, j, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int getArea(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] != 0 && grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 3;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int value = 1;
        for (int[] dir : dirs) {
            int newI = dir[0] + i;
            int newJ = dir[1] + j;
            value += getArea(newI, newJ, grid);
        }
        return value;
    }

    private void markWater(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 1 || grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 2;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int newI = dir[0] + i;
            int newJ = dir[1] + j;
            markWater(newI, newJ, grid);
        }
    }

    @Test
    public void test(){
        int[][] grid = new int[][]{{1,1, 1}, {1, 0, 1}, {1, 1, 1}};
        int area = maxAreaOfClosedIsland(grid);
        grid = new int[][]{{1,1}, {1, 0}};
        area = maxAreaOfClosedIsland(grid);
        grid = new int[][]{{0,1, 1}, {1, 0, 0}, {1, 1, 1}};
        area = maxAreaOfClosedIsland(grid);

    }
}

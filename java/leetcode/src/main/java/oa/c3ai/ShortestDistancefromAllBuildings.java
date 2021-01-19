package oa.c3ai;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancefromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];
        int[][] reachable = new int[rows][cols];
        int numOfBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, grid, distance, reachable);
                    numOfBuildings++;
                }
            }
        }
        int shortestDist = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if (reachable[i][j] == numOfBuildings) {
                    shortestDist = Math.min(shortestDist, distance[i][j]);
                }
            }
        }
        return shortestDist == Integer.MAX_VALUE? -1 :shortestDist;
    }

    private void bfs(int row, int col, int[][] grid, int[][] distance, int[][] reachable) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++dist;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : direction) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (!isValid(x, y, isVisited, grid)) {
                        continue;
                    }
                    distance[x][y] += dist;
                    reachable[x][y]++;
                    isVisited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }

            }
        }
    }

    private boolean isValid(int x, int y, boolean[][] isVisited, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (x < 0 || x >= rows || y < 0 || y > cols -1) {
            return false;
        }
        if (isVisited[x][y] || grid[x][y] != 0) {
            return false;
        }
        return true;
    }
    @Test
    public void test(){
        int[][] array = new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        int ans = shortestDistance(array);
    }
}

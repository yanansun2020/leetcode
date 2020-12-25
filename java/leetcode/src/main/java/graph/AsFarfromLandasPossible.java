package graph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];
        Queue<Integer> queue = new LinkedList<>();
        init_distance(grid, distance, queue);
        return bfs(grid, distance, queue);
    }
    int bfs(int[][] grid, int[][] distance, Queue<Integer> queue){
        int maxStep = -1;
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Integer topEle = queue.poll();
            int row = topEle/100;
            int col = topEle%100;
            for (int[] dir : direction) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                    continue;
                }
                if (grid[newRow][newCol] == 0) {
                    if (distance[newRow][newCol] == 0) {
                        distance[newRow][newCol] = 1 + distance[row][col];
                    } else {
                        distance[newRow][newCol] = Math.min(distance[newRow][newCol], 1 + distance[row][col]);
                    }
                    queue.offer(newRow * 100 + newCol);
                    maxStep = Math.max(maxStep, distance[newRow][newCol]);
                }
            }
            grid[row][col] = 1;
        }
        return maxStep;
    }
    void init_distance(int[][] grid, int[][] distance, Queue<Integer> queue){
        for (int i = 0; i < grid.length; i++){
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    distance[i][j] = 0;
                    queue.offer(i * 100 + j);
                }
            }
        }
    }

    @Test
    public void test(){
        int[][] grid = new int[][]{{1,0,1}, {0, 0, 0}, {1,0,1}};
        int ans = maxDistance(grid);
        grid = new int[][]{{1,0,0}, {0, 0, 0}, {0,0,0}};
        ans = maxDistance(grid);
        grid = new int[][]{{1,1,1}, {1,1,1}, {1,1,1}};
        ans = maxDistance(grid);
    }
}

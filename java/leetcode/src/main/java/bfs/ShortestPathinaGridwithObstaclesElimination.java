package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        if (row == 0) {
            return -1;
        }
        int[][] visited = new int[row][grid[0].length];
        for (int[] i: visited) Arrays.fill(i, Integer.MAX_VALUE);
        return bfs(grid, k, visited);
    }
    
    private int bfs(int[][] grid, int k, int[][] visited) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Coordinate c = new Coordinate(0, 0, 0);
        visited[0][0] = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(c);
        int steps = 0;
        int row = grid.length;
        int col = grid[0].length;
        while (!queue.isEmpty() ) {
            int size = queue.size();
            while (size-- > 0) {
                Coordinate cur = queue.poll();
                int r = cur.r;
                if (r < 0) {
                    continue;
                }
                if (cur.x == row - 1 && cur.y == col -1) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int x1 = cur.x + dir[0];
                    int y1 = cur.y + dir[1];
                    if (x1 < 0 || x1 > row - 1 || y1 < 0 || y1 > col -1) {
                        continue;
                    }
                    int newK = r + grid[x1][y1];
                    if (newK > k) {
                        continue;
                    }
                    if (newK >= visited[x1][y1]) {
                        continue;
                    }
                    queue.offer(new Coordinate(x1, y1, newK));
                    visited[x1][y1] = newK;
                }
            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) {
        ShortestPathinaGridwithObstaclesElimination s = new ShortestPathinaGridwithObstaclesElimination();
        int[][] arr = new int[][]{{0,1,0,0,0,1,0,0},{0,1,0,1,0,1,0,1},{0,0,0,1,0,0,1,0}};
        // arr = new int[][]{{0, 1, 0, 0}, {0,1,0,1}, {0, 0, 1, 0}};
        int a = s.shortestPath(arr, 1);
    }
}
class Coordinate{
    int x;
    int y;
    int r;
    Coordinate(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
package oa.amazon.ftoa;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        bfs(matrix, queue);
        return matrix;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] visited = new int[rows][cols];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] topEle = queue.poll();
                for (int[] direction : directions){
                    int x = topEle[0] + direction[0];
                    int y = topEle[1] + direction[1];
                    if (!isValidPos(x, y, matrix, visited)) {
                        continue;
                    }
                    matrix[x][y] = Math.min(matrix[x][y], distance);
                    visited[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
    private boolean isValidPos(int x, int y, int[][] matrix, int[][] visited) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (x < 0 || x > rows - 1 || y < 0 || y > cols -1) {
            return false;
        }
        if (visited[x][y] == 1) {
            return false;
        }
        if (matrix[x][y] == 0) {
            return false;
        }
        return true;
    }
    @Test
    public void test(){
        int[][] matrix = new int[][]{{0,0,0},
            {0,1,0},
            {1,1,1}};

        updateMatrix(matrix);
    }
}

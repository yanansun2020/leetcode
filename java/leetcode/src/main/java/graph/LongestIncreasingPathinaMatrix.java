package graph;

import org.junit.Test;

public class LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] longestPath = new int[rows][cols];
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited = new int[rows][cols];
                dfs(i, j, matrix, visited, longestPath);
            }
        }
        int longestPath1 = 0;
        for (int i = 0; i < longestPath.length; i++) {
            for (int j = 0; j < longestPath[0].length; j++) {
                longestPath1 = Math.max(longestPath1, longestPath[i][j]);
            }
        }
        return longestPath1;
    }
    int dfs(int row, int col, int[][] matrix, int[][] visited, int[][] longestPath){
        visited[row][col] = 1;
        if (longestPath[row][col] > 0) {
            System.out.println(longestPath[row][col]);
            return longestPath[row][col];
        }
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxPath = 1;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length) {
                continue;
            }
            if (longestPath[newRow][newCol] == 0 && visited[newRow][newCol] == 1) {
                continue;
            }

            if (matrix[newRow][newCol] > matrix[row][col]) {
                maxPath = Math.max(maxPath, 1 + dfs(newRow, newCol, matrix, visited, longestPath)) ;
            }
        }
        longestPath[row][col] = maxPath;
        return maxPath;
    }

    @Test
    public void test(){
        int[][] matrix = new int[][]{{9,9,4},
            {6,6,8},
            {2,1,1}};
        int ans = longestIncreasingPath(matrix);
        matrix = new int[][]{{3,4,5},
            {3,2,6},
            {2,2,1}};
        ans = longestIncreasingPath(matrix);
        matrix = new int[][]{{13, 5,13,9},
            {5, 0, 2, 9},
            {10, 13, 11, 10},
            {0, 0, 13, 13}};
        ans = longestIncreasingPath(matrix);
    }

}

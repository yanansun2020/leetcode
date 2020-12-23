package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AsFarfromLandasPossible {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
       int[][] distance = new int[grid.length][grid[0].length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        List<Coordinate> lst = init_distance(grid, distance);
        for (Coordinate coordinate : lst) {

        }
        return 0;
    }
    Coordinate findFarWater(Coordinate start, int[][] grid, int[][] distance){
        Coordinate res = null;
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Coordinate ele = queue.poll();
            for (int[] dir : direction) {
                int newRow = ele.row + dir[0];
                int newCol = ele.col + dir[1];
                if (newRow < 0 || newRow > grid.length || newCol < 0 || newCol > grid[0].length) {
                    continue;
                }
                if (grid[newRow][newCol] == 0) {
                }
            }
        }
        return null;
    }
    List<Coordinate> init_distance(int[][] grid, int[][] distance){
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < grid.length; i++){
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    Coordinate coo = new Coordinate(i, j);
                    coordinates.add(coo);
                    distance[i][j] = 0;
                }
            }
        }
        return coordinates;
    }
}
class Coordinate{
    int row;
    int col;
    Coordinate(int row, int col){
        this.row = row;
        this.col = col;
    }
}

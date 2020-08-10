package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<RottedGrid> queue = new LinkedList<>();
        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    RottedGrid rottedGrid = new RottedGrid(i, j, 0);
                    queue.add(rottedGrid);
                }
            }
        }
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
        while(!queue.isEmpty()){
            RottedGrid rottedGrid = queue.poll();
            count = rottedGrid.depth;
            for (int i = 0; i < directions.length; i++) {
                Integer x = rottedGrid.x + directions[i][0];
                Integer y = rottedGrid.y + directions[i][1];
                if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length-1) {
                    continue;
                }
                if(grid[x][y] == 0 || grid[x][y] == 2){
                    continue;
                }
                grid[x][y] = 2;
                queue.offer(new RottedGrid(x, y, rottedGrid.depth + 1));
            }
        }

        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RottingOranges test = new RottingOranges();
        int[][] grid0 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(test.orangesRotting(grid0));
        int[][] grid1 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(test.orangesRotting(grid1));
        int[][] grid2 = {{0,2}};
        System.out.println(test.orangesRotting(grid2));
    }
}

class RottedGrid{
    int x;
    int y;
    int depth;
    RottedGrid(){}
    RottedGrid(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

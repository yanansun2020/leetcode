package contest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MinimumDays {
    public int minDays(int[][] grid) {
        if(!isConnected(grid)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        for(int i =0; i <grid.length; i++ ){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited.contains(i + "," + j)){
                    grid[i][j] = 0;
                    if(!isConnected(grid)){
                        return 1;
                    }
                    visited.add(i + "," + j);
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    public boolean isConnected(int[][] grid){
        Set<String> visited = new HashSet<>();
        int count = 0;
        for(int i =0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                String tuple = i + "," + j;
                if(grid[i][j] == 1 && !visited.contains(tuple)){
                    dfs(i, j, grid, visited);
                    count++;
                    if(count >= 2){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void dfs(int i, int j, int[][] grid, Set<String> visited){
        if(i <0 || i > grid.length-1 || j <0 || j > grid[0].length-1){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        if(visited.contains(i+","+j)){
            return;
        }
        visited.add(i + "," + j);
        dfs(i-1, j, grid, visited);
        dfs(i+1, j, grid, visited);
        dfs(i, j-1, grid, visited);
        dfs(i, j+1, grid, visited);
    }
    @Test
    public void test(){
        int[][] grid = new int[][]{{1,0,1}, {1,1,1}, {1,0,1}};
        int day0= minDays(grid);
        int day1= minDays(new int[][]{{0,1,1,0},{0,1,1,0},{0,0,0,0}});
        int day2= minDays(new int[][]{{1,1}});
        int day3= minDays(new int[][]{{1,0,1,0}});
        int day4= minDays(new int[][]{{1,1,0,1,1},
            {1,1,1,1,1},
            {1,1,0,1,1},
            {1,1,1,1,1}});
    }
}

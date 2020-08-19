package array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if(grid== null || grid.length == 0){
            return 0;
        }
        Set<String> positions = new HashSet<>();
        for(int i =0; i<grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    String s = dfs(i, j, "", grid, i, j);
                    positions.add(s);
                }
            }
        }
        return positions.size();
    }
    public String dfs(int i, int j, String position, int[][] grid, int x, int y){
        if(i<0 || i >=grid.length || j <0 || j >= grid[0].length){
            return "";
        }
        if(grid[i][j] != 1){
            return "";
        }
        grid[i][j] = 2;
        String top = dfs(i-1, j,position, grid, x, y);
        String bottom = dfs(i+1, j,position, grid,x, y);
        String left = dfs(i, j-1, position, grid,x, y);
        String right = dfs(i, j+1,position, grid, x, y);
        return top+bottom+left+right + "_" + (i-x) + "_" + (j-y);
    }
    @Test
    public void test(){
//        int[][] array = {{1,1}};
        int[][] array = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int a = numDistinctIslands(array);
    }
}

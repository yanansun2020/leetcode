package oa.amazon.ftoa;

/**
 *  https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int numOfIsland = 0;
        for(int i =0; i< rows; i++){
            for(int j =0; j < cols; j ++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    numOfIsland++;
                }
            }
        }
        return numOfIsland;
    }
    public void dfs(int i, int j, char[][] grid){
        if(i<0 || i > grid.length-1 || j < 0 || j > grid[0].length -1){
            return;
        }
        if(grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);

    }
}

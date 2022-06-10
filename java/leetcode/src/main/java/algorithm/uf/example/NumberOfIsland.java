package algorithm.uf.example;

import algorithm.uf.UnionFind2D;
import org.junit.Test;

public class NumberOfIsland {
    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        UnionFind2D uf = new UnionFind2D(grid);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i-1][j] == '1') {
                        uf.union(i * c + j, (i-1) * c + j);
                    }
                    if (i + 1 < c && grid[i + 1][j] == '1') {
                        uf.union(i * c + j, (i+1) * c + j);
                    }
                    if (j - 1 >= 0 && grid[i][j-1] == '1') {
                        uf.union(i * c + j, i * c + j - 1);
                    }
                    if (j + 1 < c && grid[i][j+1] == '1') {
                        uf.union(i * c + j, i * c + j + 1);
                    }
                }
            }
        }
        return uf.count_of_group;
    }
    @Test
    public void test(){
        char[][] grid = {{'1', '0', '0'}, {'1', '0', '0'}, {'0', '1', '1'}};
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int res = numIslands(grid1);
    }
}

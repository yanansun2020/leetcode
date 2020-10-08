package unionfind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NumberofIslandII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UnionFindChar unionFind = new UnionFindChar(m * n);
        int[][] unioned = new int[m][n];
        int[][] directions = new int[][]{{-1, 0}, {1,0}, {0, -1}, {0, 1}};
        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            if (unioned[r][c] == 0) {
                unionFind.setParent(r * n + c);
            }
            unioned[r][c] = 1;
            for (int[] direction : directions) {
                int x = r + direction[0];
                int y = c + direction[1];
                if (x < 0 || x > m -1 || y < 0 || y > n - 1) {
                    continue;
                }
                if (unioned[x][y] == 1) {
                    unionFind.union(r * n + c, x * n + y);
                }

            }
            ans.add(unionFind.count);
        }
        return ans;
    }

    @Test
    public void test(){
        int[][] positions = new int[][]{{0,0},{0,1},{1,2},{1,2}};
        List<Integer> ans = numIslands2(3, 3, positions);
    }
}

package oa.c3ai;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * worst Time complexity: O(N!)
 */
public class BeautifulArrangement {
    public int countArrangement(int n) {
        int[] visited = new int[n + 1];
        return dfs(1, n, visited);
    }
    public int dfs(int pos, int n, int[] visited){
        if (pos > n) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++ ) {
            if (visited[i] == 1) {
                continue;
            }
            if (i % pos!= 0 && pos % i != 0) {
                continue;
            }
            visited[i] = 1;
            count += dfs(pos + 1, n, visited);
            visited[i] = 0;
        }
        return count;
    }
    @Test
    public void test(){
        int ans = countArrangement(4);
    }
}

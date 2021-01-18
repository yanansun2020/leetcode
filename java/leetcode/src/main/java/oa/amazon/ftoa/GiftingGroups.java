package oa.amazon.ftoa;

import org.junit.Test;

/**
 * adjacent matrix
 * time complexity : O(n^2) traversal the matrix
 * Space complexity : O(n). visited array of size nis used.
 */
public class GiftingGroups {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, isConnected, visited);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfs(int i, int[][] isConnected, int[] visited) {
        if (visited[i] == 1) {
            return;
        }
        visited[i] = 1;
        for (int j = 0; j < isConnected.length; j++) {
            if (visited[j] == 0 && isConnected[i][j] == 1) {
                dfs(j, isConnected, visited);
            }
        }
    }

    @Test
    public void test(){
        int[][] nums = new int[][]{{1,1,0}, {1,1,0}, {0, 0, 1}};
        int ans = findCircleNum(nums);
    }
}

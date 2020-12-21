package unionfind;

import org.junit.Test;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            unionFind.union(x, y);
        }
        if (unionFind.getCircle() == 1 && unionFind.extraConnection == 0) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        int[][] edges = new int[][]{{0,1}, {0,2}, {0,3}, {1,4}};
        boolean ans = validTree(5, edges);
        edges = new int[][]{{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        ans = validTree(5, edges);
    }
}

package unionfind;

import org.junit.Test;

import java.util.List;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            unionFind.union(x, y);
        }
        List<List<Integer>> extraEdges = unionFind.extraedges;
        if (extraEdges.size() == 0 ) {
            return null;
        }
        List<Integer> extraEdge = extraEdges.get(0);
        int[] ans = new int[2];
        ans[0] = Math.min(extraEdge.get(0), extraEdge.get(1)) + 1;
        ans[1] = Math.max(extraEdge.get(0), extraEdge.get(1)) + 1;
        return ans;
    }

    @Test
    public void test() {
        int[][] edges = new int[][]{{1,2}, {1,3}, {2,3}};
        int[] ans = findRedundantConnection(edges);
        edges = new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        ans = findRedundantConnection(edges);
    }
}

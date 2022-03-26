package oa.gg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            unionFind.union(x, y);
        }
        List<int[]> extraEdges = unionFind.getExtras();
        if (extraEdges.size() == 0 ) {
            return null;
        }
        int[] extraEdge = extraEdges.get(0);
        int[] ans = new int[2];
        ans[0] = Math.min(extraEdge[0], extraEdge[1]);
        ans[1] = Math.max(extraEdge[0], extraEdge[1]);
        return ans;
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{{1,2},{1,3},{2,3}};
        int[] ans = findRedundantConnection(arr);
    }
}

class UnionFind {
    int[] parent;
    List<int[]> extras;
    UnionFind(int n) {
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        extras = new ArrayList<>();
    }

    int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        int p = find(parent[x]);
        parent[x] = p;
        return p;
    }

    void union(int x, int y) {
        int p_x = find(x);
        int p_y = find(y);
        if (p_x == p_y) {
            extras.add(new int[]{x, y});
        }
        parent[p_y] = p_x;
    }

    List<int[]> getExtras() {
        return extras;
    }
}

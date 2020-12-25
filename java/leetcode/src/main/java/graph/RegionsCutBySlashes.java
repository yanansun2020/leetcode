package graph;

/**
 * A 1 * 1 square can be split into 4 triangles, start from top 0-3 in clockwise
 * if \ then merge 0-1 and 2-3
 * if / then merge 0 3 and 1 2
 * Between squares, 1-3 and 2-0 need to be merges
 */
public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        DSU dsu = new DSU(4 * n * n);
        for (int r = 0; r < n; ++r)
            for (int c = 0; c < n; ++c) {
                int index = 4 * (r * n + c);
                switch (grid[r].charAt(c)) {
                    case '/':
                        dsu.union(index + 0, index + 3);
                        dsu.union(index + 1, index + 2);
                        break;
                    case '\\':
                        dsu.union(index + 0, index + 1);
                        dsu.union(index + 2, index + 3);
                        break;
                    case ' ':
                        dsu.union(index + 0, index + 1);
                        dsu.union(index + 1, index + 2);
                        dsu.union(index + 2, index + 3);
                        break;
                    default:
                        break;
                }
                if (r + 1 < n)
                    dsu.union(index + 2, index + 4 * n + 0);
                if (c + 1 < n)
                    dsu.union(index + 1, index + 4 + 3);
            }
        int ans = 0;
        for (int i = 0; i < 4 * n * n; ++i)
            if (dsu.find(i) == i) ++ans;
        return ans;
    }
}
class DSU {
    int[] parent;
    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}


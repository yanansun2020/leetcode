package algorithm.uf;

/**
 * number of islands
 */
public class UnionFind2D {
    private int[] parent;
    public int count_of_group;
    public UnionFind2D(char[][] grid) {
        count_of_group = 0;
        int row = grid.length;
        int col = grid[0].length;
        parent = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1'){
                    int k = i * col + j;
                    this.parent[ i * col + j] =  i * col + j;
                    this.parent[k] =  k;
                    count_of_group++;
                }
            }
        }
    }

    //find the parent of a node
    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    public void union(int p, int q)
    {
        int parent_p = find(p);
        int parent_q = find(q);
        if (parent_p != parent_q) {
            parent[parent_p] = parent_q;
            this.count_of_group--;
        }
    }
}

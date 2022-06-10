package algorithm.uf;

public class PathCompression {
    private int[] id;
    private int[] size;
    public PathCompression(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }
    private int root(int i) {
        while (i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }
}

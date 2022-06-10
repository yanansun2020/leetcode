package algorithm.uf;

public class QuickFindUF {
    int[] parent = null;

    QuickFindUF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; //parent is itself
        }
    }
    public boolean connected(int p, int q) {
        return parent[p] == parent[q];
    }

    public void union(int p, int q)
    {
        int pid = parent[p];
        int qid = parent[q];
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == pid) parent[i] = qid;
        }
    }
}

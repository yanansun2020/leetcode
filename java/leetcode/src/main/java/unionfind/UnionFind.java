package unionfind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionFind {
    int n;
    int[] parent;
    int[] rank;
    List<List<Integer>> extraedges = new ArrayList<>();
    /**
     * The connections are duplicated to make a group
     * also means there is a cycle
     */
    int extraConnection;
    public UnionFind(int n){
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public UnionFind(int n, int start){
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = start; i < n + start; i++) {
            parent[i - start] = i;
        }
    }
    public UnionFind(int[] parent){
        this.n = parent.length;
        this.parent = parent;
        this.rank = new int[n];
    }

    /**
     * return the parent of x
     * @param x
     * @return
     */
    public int find(int x){
        if (parent[x] == x){
            return x;
        }
        int par = find(parent[x]);
        parent[x] = par;
        return par;
    }

    public void union (int x, int y){
        int par_x = find(x);
        int par_y = find(y);
        if (par_x == par_y) {
            extraConnection++;
            List<Integer> extrageEdge = new ArrayList<>();
            extrageEdge.add(x);
            extrageEdge.add(y);
            extraedges.add(extrageEdge);
        }
        int rank_x = rank[par_x];
        int rank_y = rank[par_y];
        if (rank_x >= rank_y) {
            parent[par_y] = par_x;
            rank[par_x]++;
        } else {
            parent[par_x] = par_y;
            rank[par_y]++;
        }
    }

    public int getCircle(){
        for (int i = 0; i < n; i++) {
            find(i);
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int par : parent) {
            set.add(par);
        }
        return set.size();
    }
}

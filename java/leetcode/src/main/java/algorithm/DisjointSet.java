package algorithm;

/**
 * upstream master changed11231
 */
public class DisjointSet {
    int[] parents = null;//index:tree number parents[i] parent of tree i
    int[] rank = null;//tree size

    public DisjointSet(int size){
        parents = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i; //parents is itself
            rank[i] = 0;
        }
    }
    public int findSet(int node){
        int parent = parents[node];
        if(parent == node){
            return parent;
        }
        parents[node] = findSet(parent);
        return parents[node];
    }
    public boolean union(int node1, int node2){
        int parent1 = findSet(node1);
        int parent2 = findSet(node2);
        if(parent1 == parent2){
            return false;
        }
        if(rank[parent1] >= rank[parent2]){
            rank[parent1] = (rank[parent1] == rank[parent2])? rank[parent1] +1 :rank[parent1];
            parents[parent2] = parent1;
        }else{
            parents[parent1] = parent2;
        }
        return true;
    }
}

package algorithm.uf;

class UnionFind {
    int[] parent = null;
    int[] size = null;

    UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; //parent is itself
            size[i] = 1;
        }
    }

    void union(int a, int b) {
        int parent_a = find(a);
        int parent_b = find(b);
        if (parent_a != parent_b) {
            parent[parent_b] = parent_a; //parents merge
            size[parent_a] += size[parent_b];
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    //determine if x and y are connected
    boolean connected(int x, int y) {
        return parent[x] == parent[y];
    }

    int findMaxSize() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < size.length; i++) {
//                System.out.println("parent["+i+"]"+parent[i]+" size[" +i +"]"+ size[i]);
            if (size[i] > max) {
                max = size[i];
                index = i;
            }
        }
        return index;
    }
}

package algorithm;

class UnionFind {
    int[] parents = null;
    int[] size = null;

    UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i; //parents is itself
            size[i] = 1;
        }
    }

    void union(int a, int b) {
        int parent_a = find(a);
        int parent_b = find(b);
        if (parent_a != parent_b) {
            parents[parent_b] = parent_a; //parents merge
            size[parent_a] += size[parent_b];
        }
    }

    int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    int findMaxSize() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < size.length; i++) {
//                System.out.println("parents["+i+"]"+parents[i]+" size[" +i +"]"+ size[i]);
            if (size[i] > max) {
                max = size[i];
                index = i;
            }
        }
        return index;
    }
}

package unionfind;

import org.junit.Test;

public class NumberofConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            unionFind.union(x, y);
        }
        return unionFind.getCircle();
    }

    @Test
    public void test() {
        int[][] array3 = new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
        int ans3 = countComponents(10, array3);

        int[][] array2 = new int[][]{{0, 1}, {2,3}, {1, 2},};
        int ans2 = countComponents(4, array2);

        int[][] array = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        int ans = countComponents(5, array);

        int[][] array1 = new int[][]{{0, 1}, {1, 2},{2,3},{3, 4}};
        int ans1 = countComponents(5, array1);


    }
}

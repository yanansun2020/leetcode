package unionfind;

import org.junit.Test;

public class NumberOperationsMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (n <=0 || connections.length <= 0) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            unionFind.union(x, y);
        }
        int numOfCircle = unionFind.getCircle();
        if (unionFind.extraConnection < numOfCircle-1) {
            return -1;
        }
        return numOfCircle - 1;
    }

    @Test
    public void test(){
        int[][] connections = new int[][]{{0,1},{0,2},{1,2}};
        int ans = makeConnected(4, connections);
        connections = new int[][]{{0,1},{0,2},{0, 3}, {1,2}, {1, 3}};
        ans = makeConnected(6, connections);
        connections = new int[][]{{0,1},{0,2},{0, 3}, {1,2}};
        ans = makeConnected(6, connections);
    }
}

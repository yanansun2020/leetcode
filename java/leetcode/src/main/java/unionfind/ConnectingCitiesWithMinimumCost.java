package unionfind;

import org.junit.Test;

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int N, int[][] connections) {
        UnionFind unionFind = new UnionFind(N);
        Arrays.sort(connections, ((o1, o2) -> o1[2] - o2[2]));
        for (int[] connection : connections) {
            int x = connection[0] - 1;
            int y = connection[1] - 1;
            int cost = connection[2];
            unionFind.union(x, y, cost);
        }
        if (unionFind.getCircle() > 1) {
            return -1;
        }
        return unionFind.minimumCost;
    }

    @Test
    public void test() {
        int[][] connections = new int[][]{{1,2,5},{1,3,6},{2,3,1}};
        int cost = minimumCost(3, connections);
        connections = new int[][]{{1,2,3},{3,4,4}};
        cost = minimumCost(4, connections);
    }
}

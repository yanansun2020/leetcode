package unionfind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCosttoConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+ 1; j < points.length; j++) {
                List<Integer> edge = new ArrayList();
                edge.add(i);
                edge.add(j);
                edge.add(getCost(points[i], points[j]));
                edges.add(edge);
            }
        }
        Collections.sort(edges, (o1, o2)-> o1.get(2) - o2.get(2));
        UnionFind unionFind = new UnionFind(points.length);
        for (List<Integer> edge : edges) {
            unionFind.union(edge.get(0), edge.get(1), edge.get(2));
        }
        return unionFind.minimumCost;
    }

    private Integer getCost(int[] point, int[] point1) {
        return Math.abs(point[0] - point1[0]) + Math.abs(point[1] - point1[1]);
    }

    @Test
    public void test() {
        int[][] points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        int ans = minCostConnectPoints(points);
        points = new int[][]{{3,12},{-2,5},{-4,1}};
        ans = minCostConnectPoints(points);
        points = new int[][]{{0,0},{1,1},{1,0},{-1,1}};
        ans = minCostConnectPoints(points);
        points = new int[][]{{-1000000,-1000000},{1000000,1000000}};
        ans = minCostConnectPoints(points);
        points = new int[][]{{0, 0}};
        ans = minCostConnectPoints(points);
    }
}

package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the value of visited is important, when return from dfs, reset it to zero
 */
public class AllPathsfromSourceLeadtoDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = getAdjacent(edges);
        int[] visited =  new int[n];
        return dfs(source, destination, map, visited);
    }
    boolean dfs(int source, int dest, Map<Integer, List<Integer>> map, int[] visited){
        if (source == dest && map.get(dest) == null) {
            return true;
        }
        if (visited[source] == 1) {
            return false;
        }

        visited[source] = 1;
        List<Integer> neighbors = map.get(source);
        if (neighbors == null || neighbors.size() == 0) {
            return false;
        }
        for (Integer neighbor : neighbors) {
            boolean toDest = dfs(neighbor, dest, map, visited);
            if (!toDest) {
                return false;
            }
        }
        visited[source] = 0;
//        accessible[source] = 1;
        return true;
    }
    Map<Integer, List<Integer>> getAdjacent(int[][] edges){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            List<Integer> adjacent = map.getOrDefault(start, new ArrayList<>());
            if (!adjacent.contains(end)){
                adjacent.add(end);
                map.put(start, adjacent);
            }
        }
        return map;
    }
    @Test
    public void test(){
        int[][] edges = new int[][]{{0,1},{0,2}};
        boolean ans = leadsToDestination(3, edges, 0, 2);
        edges = new int[][]{{0,1},{0,3},{1,2},{2,1}};
        ans = leadsToDestination(4, edges, 0, 3);
        edges = new int[][]{ {0,1},{0,2},{1,3},{2,3}};
        ans = leadsToDestination(4, edges, 0, 3);
        edges = new int[][]{ {0,1},{1,1},{1,2}};
        ans = leadsToDestination(3, edges, 0,2);
        edges = new int[][]{{0, 1}, {1, 1}};
        ans = leadsToDestination(2, edges, 0, 1);
        edges = new int[][]{{0,1},{0,2},{0,3},{0,3},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};
        ans = leadsToDestination(5, edges, 0, 4);
    }
}

package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dfs+memory to find longest path
 * O(V * V)
 */
public class ParallelCourses {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> map = getNeighbors(relations);
        int longestPath = 0;
        int[] visited = new int[N+1];
        int[] path = new int[N+1];
        for (int i = 1; i <= N; i++) {
            if (dfs(i, map, visited, path) < 0){
                return -1;
            }
        }
        for (int i = 0; i < path.length; i++) {
            longestPath = Math.max(path[i], longestPath);
        }
        return longestPath;
    }

    int dfs(int node, Map<Integer, List<Integer>> neighborsMap, int[] visited, int[] paths){
        if (visited[node] == 1) {
            return -1;
        }
        if (paths[node] > 0){
            return paths[node];
        }
        List<Integer> neighbors = neighborsMap.get(node);
        if (neighbors == null || neighbors.size() == 0) {
            paths[node] = 1;
            return 1;
        }
        visited[node] = 1;
        int longestPath = 0;
        for (int neighbor : neighbors) {
            int path = dfs(neighbor, neighborsMap, visited, paths);
            if (path == -1) {
                return path;
            }
            longestPath = Math.max(path, longestPath);
        }
        paths[node] = longestPath + 1;
        visited[node] = 0;
        return paths[node];
    }

    Map<Integer, List<Integer>> getNeighbors(int[][] relations) {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int[] relation : relations) {
            List<Integer> lst = neighbors.getOrDefault(relation[1], new ArrayList<>());
            lst.add(relation[0]);
            neighbors.put(relation[1], lst);
        }
        return neighbors;
    }

    @Test
    public void test(){
        int[][] relations = new int[][]{{1,3}, {2,3}};
        int ans = minimumSemesters(3, relations);
        relations = new int[][]{{1,2},{2,3},{3,1}};
        ans = minimumSemesters(3, relations);
    }
}

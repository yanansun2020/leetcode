package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * degree check
 * 剥洋葱解法：从外层向里层进行BFS遍历
 * bfs method is important(a new way for bfs)
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n==1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        init_degree(edges, degree);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        Map<Integer, List<Integer>> neighborMap = getMap(edges);
        bfs(queue, neighborMap, degree, n);

        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }
    void bfs(Queue<Integer> queue, Map<Integer, List<Integer>> neighborMap, int[] degree, int n){
        while (n > 2){
            int size = queue.size();
            n -= size;
            int i = 0;
            while (i < size) {
                Integer topEle = queue.poll();
                degree[topEle]--;
                List<Integer> neighbors = neighborMap.get(topEle);
                for (Integer neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
                i++;
            }
        }
    }


    void init_degree(int[][] edges, int[] degree){
        for (int[] edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
    }

    Map<Integer, List<Integer>> getMap(int[][] edges){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> adjacents = map.getOrDefault(edge[0], new ArrayList<>());
            adjacents.add(edge[1]);
            map.put(edge[0], adjacents);

            List<Integer> adjacents1 = map.getOrDefault(edge[1], new ArrayList<>());
            adjacents1.add(edge[0]);
            map.put(edge[1], adjacents1);

        }
        return map;
    }

    public List<Integer> findMinHeightTrees_TLE(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = getMap(edges);
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];
            int[] min_height = new int[n];
            int hi = dfs(i, map, visited, min_height);
            height[i] = hi;
        }
        int rootHeight = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] == rootHeight){
                ans.add(i);
            }else if (height[i] <rootHeight) {
                ans = new ArrayList<>();
                ans.add(i);
                rootHeight = height[i];
            }
        }
        return ans;
    }

    int dfs(int node, Map<Integer, List<Integer>> map, int[] visited, int[] height){
        if (height[node] > 0) {
            return height[node];
        }
        visited[node] = 1;
        List<Integer> neighbors = map.getOrDefault(node, new ArrayList<>());
        if (neighbors == null || neighbors.size() == 0) {
            height[node] = 1;
            return 1;
        }
        int maxDepth = 0;
        for (Integer neighbor : neighbors) {
            if(visited[neighbor] == 1){
                continue;
            }
            int depth = dfs(neighbor, map, visited, height);
            maxDepth = Math.max(depth, maxDepth);
        }
//        visited[node] = 0;
        height[node] = maxDepth + 1;
        return height[node];
    }


    @Test
    public void test(){
        int[][] edges = new int[][]{{1,0},{1,2},{1,3}};
        List<Integer> lst = findMinHeightTrees(4, edges);
        edges = new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}};
        lst = findMinHeightTrees(6, edges);
        edges = new int[][]{};
        lst = findMinHeightTrees(1, edges);
        edges = new int[][]{{0, 1}};
        lst = findMinHeightTrees(2, edges);
    }
}

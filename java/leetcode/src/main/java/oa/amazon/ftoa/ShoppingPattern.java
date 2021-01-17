package oa.amazon.ftoa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * idea find the cycle then all degress - 6
 */
public class ShoppingPattern {
    public static void main(String[] args) {
        System.out.println(getMinScore(6, 6, new int[]{1, 2, 2, 3, 4, 5}, new int[]{2, 4, 5, 5, 5, 6}) + " = 3");
        System.out.println(getMinScore(5, 6, new int[]{1, 1, 2, 2, 3, 4}, new int[]{2, 3, 3, 4, 4, 5}) + " = 2");
    }

    static int min;

    private static int getMinScore(int nodes, int edges, int[] from, int[] to) {
        min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            graph.computeIfAbsent(from[i], val -> new HashSet<>()).add(to[i]);
            graph.computeIfAbsent(to[i], val -> new HashSet<>()).add(from[i]);
        }
        boolean[] visited = new boolean[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            if (graph.containsKey(i)) {
                dfs(i, i, graph, visited, 0, 0);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static void dfs(int start, int cur, Map<Integer, Set<Integer>> graph, boolean[] visited, int degree, int depth) {
        visited[cur] = true;
        Set<Integer> connections = graph.getOrDefault(cur, new HashSet<>());
        degree += connections.size();
        for (int next : connections) {
            if (depth == 2) {
                if (next == start) {
                    min = Math.min(min, degree - 6);
                }
            } else if (!visited[next] && depth < 2) {
                dfs(start, next, graph, visited, degree, depth + 1);
            }
        }
        visited[cur] = false;
    }
}

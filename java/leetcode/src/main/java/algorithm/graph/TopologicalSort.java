package algorithm.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
    /**
     * n: number of nodes
     * @param n
     * @param adjacentList
     */
    public List<Integer> sort(int n, Map<Integer, List<Integer>> adjacentList){
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)){
                continue;
            }
            dfs(i, visited, stack, adjacentList);
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public void dfs(int cur, Set<Integer> visited, Stack<Integer> stack, Map<Integer, List<Integer>> adjacentList){
        visited.add(cur);
        List<Integer> neighbors = adjacentList.get(cur);
        for (Integer neighbor : neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }
            dfs(neighbor, visited, stack, adjacentList);
        }
        stack.add(cur);
    }
}

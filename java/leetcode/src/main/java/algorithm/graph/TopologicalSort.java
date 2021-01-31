package algorithm.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * topological sort
 * idea: stack + set
 * (1) add any vertex to the set
 * (2) explore(dfs) that vertex, until a node will no children
 * (3) put the last node into the stack
 *
 */
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

    @Test
    public void test() {
        char a = 1 + 'a';
        System.out.print(a);
    }
}

package algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Find strongly connected components
 */
public class Tarjans {
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] visited = new boolean[n];
        int[] lows = new int[n];
        List<Integer>[] graph = getGraph(n, connections);
        List<List<Integer>> ans = new ArrayList<>();
        int[] discovery = new int[n];
        int[] low = new int[n];
        int[] presentInStac = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(discovery, -1);
        Arrays.fill(low, -1);
        dfs(0, discovery, low, graph, stack, presentInStac);
        return ans;
    }
    private void dfs(int cur, int[] discovery, int[] lows, List<Integer>[] graph, Stack<Integer> stack, int[] presentInStack){
        discovery[cur] = time;
        lows[cur] = time;
        time++;
        stack.push(cur);
        presentInStack[cur] = 1;
        for(Integer neighbor : graph[cur]){
            if(discovery[neighbor] != -1){
                dfs(neighbor, discovery, lows, graph, stack, presentInStack);
                lows[cur] = Math.min(lows[cur], lows[neighbor]);
            }else{
                lows[cur] = Math.min(lows[cur], discovery[neighbor]);
            }
        }
        if(lows[cur] == discovery[cur]){ // if true then current node is not reachable by node visited earlier
            while (stack.peek() != cur) {
                presentInStack[cur] = 0;
                stack.pop();
            }
            presentInStack[stack.peek()] = 0;
            stack.pop();
        }
    }

    private List<Integer>[] getGraph(int n, List<List<Integer>> connections){
        List<Integer>[] graph = new ArrayList[n];
        for(List<Integer> edge: connections){
            if (graph[edge.get(0)] == null) graph[edge.get(0)] = new ArrayList();
            if (graph[edge.get(1)] == null) graph[edge.get(1)] = new ArrayList();
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        return graph;
    }
}

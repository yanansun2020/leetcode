package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Great explanation: https://www.youtube.com/watch?v=Rhxs4k6DyMM
 */
public class CriticalConnectionsinaNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] visited = new boolean[n];
        int[] lows = new int[n];
        List<Integer>[] graph = getGraph(n, connections);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, graph, visited, lows, 0, ans);
        return ans;
    }

    private int dfs(int cur, int parent, List<Integer>[] graph, boolean[] visited, int[] lows, int r, List<List<Integer>> ans){
        lows[cur] = r;
        visited[cur] = true;
        for(Integer neighbor : graph[cur]){
            if (parent == neighbor){
                continue;
            }
            if(!visited[neighbor]){
                int neirank = dfs(neighbor, cur, graph, visited, lows, r+1, ans);
                lows[cur] = Math.min(lows[cur], neirank);
            }else{
                lows[cur] = Math.min(lows[cur], lows[neighbor]);
            }
        }
        if(lows[cur] >= r){ // if true then current node is not reachable by node visited earlier
            if(parent>=0) ans.add(Arrays.asList(new Integer[]{cur, parent}));
        }
        return lows[cur];
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
    @Test
    public void test(){
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> array1 = new ArrayList<>();
        array1.add(0);
        array1.add(1);
        List<Integer> array2 = new ArrayList<>();
        array2.add(1);
        array2.add(2);
        List<Integer> array3 = new ArrayList<>();
        array3.add(2);
        array3.add(0);
        List<Integer> array4 = new ArrayList<>();
        array4.add(1);
        array4.add(3);
        connections.add(array1);
        connections.add(array2);
        connections.add(array3);
        connections.add(array4);
        System.out.println(criticalConnections(4, connections));
    }
}

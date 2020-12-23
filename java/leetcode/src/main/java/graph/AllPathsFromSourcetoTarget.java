package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * back tracking + removeLast
 */
public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int source = 0;
        int dest = graph.length - 1;
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(source, dest, graph, path, res);
        return res;
    }
    void dfs(int source, int dest, int[][] graph, LinkedList<Integer> path, List<List<Integer>> res){
        if (source == dest) {
            path.add(dest);
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(source);
        int[] neighbors = graph[source];
        for (int neighbor : neighbors) {
            dfs(neighbor, dest, graph, path, res);
            path.removeLast();
        }

    }

    @Test
    public void test(){
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> res = allPathsSourceTarget(graph);
    }

}

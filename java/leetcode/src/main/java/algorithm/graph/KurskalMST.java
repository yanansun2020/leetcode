package algorithm.graph;

import algorithm.DisjointSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KurskalMST {
    public List<Edge> getMST(int num, List<Edge> connections){
        Map<String, Integer> vertexMap = new HashMap<>();
        int index = 0;
        for(Edge connection : connections){
            if (!vertexMap.containsKey(connection.src)) vertexMap.put(connection.src, index++);
            if (!vertexMap.containsKey(connection.dest)) vertexMap.put(connection.dest, index++);
        }
        Collections.sort(connections, (c1, c2)->c1.weight-c2.weight);
        List<Edge> ans = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(vertexMap.size());
        for(Edge edge : connections){
            int start = vertexMap.get(edge.src);
            int end = vertexMap.get(edge.dest);
            if(disjointSet.union(start, end)){
                ans.add(edge);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        List<Edge> edge = new ArrayList<Edge>(){
            {
                add(new Edge("A", "B", 1));
                add(new Edge("B", "C", 4));
                add(new Edge("B", "D", 6));
                add(new Edge("D", "E", 5));
                add(new Edge("C", "E", 1));
            }
        };
        List<Edge> ans = getMST(5, edge);
    }
}

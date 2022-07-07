package algorithm.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Bellmanford time complexity:O(VE) space complexity O(V)
//Bellmanford can help detect negative weight cycle
//negative weight cycle: after v-1 relax, do one more relax,
// if the distance keep decreasing, there is a negative weight cycle
public class ShortestPath {
    public List<String> shortDis(List<Edge> connections, String start, String end){
        int index = 0;
        Map<String, Integer> vertexMap = new HashMap<>();
        Map<Integer, String> vertexIntMap = new HashMap<>();
        for(Edge connection : connections){
            if (!vertexMap.containsKey(connection.src)) vertexMap.put(connection.src, index++);
            if (!vertexMap.containsKey(connection.dest)) vertexMap.put(connection.dest, index++);
        }
        for(Map.Entry<String, Integer> entry : vertexMap.entrySet()){
            vertexIntMap.put(entry.getValue(), entry.getKey());
        }
        Bellmanford bellmanford = new Bellmanford(vertexMap.size(), vertexMap.get(start));
        for(int i =0; i < vertexMap.size()-1; i++){
            for(Edge edge:connections){
                int startPoint = vertexMap.get(edge.src);
                int endPoint = vertexMap.get(edge.dest);
                bellmanford.relax(startPoint, endPoint, edge.weight);
            }
        }
        List<Integer> shortestPath = bellmanford.getShortestPath(vertexMap.get(end));
        List<String> ans = new ArrayList<>();
        for(int i=shortestPath.size()-1; i>=0; i--){
            int node = shortestPath.get(i);
            ans.add(vertexIntMap.get(node));
        }
        return ans;
    }
    @Test
    public void test(){
        List<Edge> connections = new ArrayList<Edge>(){
            {
                add(new Edge("2", "4", 4));
                add(new Edge("3", "4", 2));
                add(new Edge("4", "3", 1));
                add(new Edge("0", "1", 4));
                add(new Edge("0", "2", 5));
                add(new Edge("0", "3", 8));
                add(new Edge("1", "2", -3));

            }
        };
        shortDis(connections, "0", "3");
    }

}

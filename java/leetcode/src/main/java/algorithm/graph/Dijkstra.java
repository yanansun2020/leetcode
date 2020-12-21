package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//single source shortest path
//works on directed and undirected graph
//weight should not be negative
public class Dijkstra {
    public int shortestPath(List<Edge> connections, String start){

        //used to select the least distance data
        PriorityQueue<Vertex> queue = new PriorityQueue<>((n1, n2) ->n1.distance-n2.distance);
        Map<String, Vertex> distanceMap = new HashMap<>();
        addAllVertexToQ(queue, start, connections, distanceMap);
        Map<String, List<Vertex>> nodesMap = GraphUtil.directed_matrixToList(connections);

        while(!queue.isEmpty()){
            Vertex curNode = queue.poll();
            List<Vertex> neighbors = nodesMap.get(curNode.name);
            for(Vertex neighbor : neighbors){
                Vertex next = distanceMap.get(neighbor.name);
                if (next.distance > curNode.distance + neighbor.distance) {
                    next.distance = curNode.distance + neighbor.distance;
                    next.path = curNode;
                }
            }
        }
        return 0;
    }

    public void addAllVertexToQ(PriorityQueue<Vertex> queue, String start, List<Edge> connections, Map<String, Vertex> distanceMap){
        for (Edge edge : connections) {
            Vertex vertex = new Vertex();
            vertex.name = edge.end;
            vertex.distance = Integer.MAX_VALUE;
            if (start.equals(edge.start)) {
                vertex.distance = edge.weight;
            }
            distanceMap.put(vertex.name, vertex);
            queue.add(vertex);
        }
    }
}

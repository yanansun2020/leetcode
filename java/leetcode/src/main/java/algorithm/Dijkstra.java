package algorithm;

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
        Map<String, List<Node>> nodesMap = getGraph(connections);
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) ->n1.distance-n2.distance);
        Map<String, Node> map = new HashMap<>();
        for(String key : nodesMap.keySet()){
            Integer dis = start.equals(key)? 0 : Integer.MAX_VALUE;
            Node n = new Node(key, dis);
            map.put(key, n);
            queue.offer(n);
        }
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if(start.equals(curNode.name)){
                distanceMap.put(curNode.name, 0);//todo
                parentMap.put(curNode.name, null);
                map.remove(curNode.name);
            }
            List<Node> neighbors = nodesMap.get(curNode.name);
            for(Node neighbor : neighbors){
                if(!map.containsKey(neighbor.name)){
                    continue;
                }
                if(map.get(neighbor.name).distance > curNode.distance +neighbor.distance){
                }

            }

        }
        return 0;
    }

    private Map<String, List<Node>> getGraph(List<Edge> connections){
        Map<String, List<Node>> nodesMap = new HashMap<>();
        for(Edge connection : connections){
            List<Node> neighbors = nodesMap.getOrDefault(connection.start,new ArrayList<>());
            neighbors.add(new Node(connection.end, connection.weight));
            List<Node> neighbors1 = nodesMap.getOrDefault(connection.end,new ArrayList<>());
            neighbors1.add(new Node(connection.start, connection.weight));
            nodesMap.put(connection.start, neighbors);
            nodesMap.put(connection.end, neighbors1);
        }
        return nodesMap;
    }
}

class Node{
    String name;
    Integer distance;
    Node(String name, Integer distance){
        this.name = name;
        this.distance = distance;
    }
}

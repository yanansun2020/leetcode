package algorithm.graph;

import java.util.ArrayList;
import java.util.List;

//single source shortest path
//find shortest path from single source to all the other vertices
//worked for negative edges
public class Bellmanford {
    Integer[] distance = null;
    Integer[] parent = null;
    Integer vertices = null;

    public Bellmanford(int size, int startPoint){
        distance = new Integer[size];
        parent = new Integer[size];;
        vertices = size;
        for(int i =0; i < size; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[startPoint] = 0;
    }

    public void relax(int start, int end, int weight){
        if(distance[start] == Integer.MAX_VALUE){
            return;
        }
        if(distance[end]> distance[start] + weight){
            distance[end] = distance[start] + weight;
            parent[end] = start;
        }
    }
    List<Integer> getShortestPath(Integer end){
        List<Integer> shortestPath = new ArrayList<>();
        while( end!= null){
            shortestPath.add(end);
            end = parent[end];
        }
        return shortestPath;
    }
}

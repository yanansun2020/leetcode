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

    public Bellmanford(int size, int src){
        distance = new Integer[size];
        parent = new Integer[size];;
        vertices = size;
        for(int i =0; i < size; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
    }

    public void relax(int src, int dest, int weight){
        if(distance[src] == Integer.MAX_VALUE){
            return;
        }
        if(distance[dest]> distance[src] + weight){
            distance[dest] = distance[src] + weight;
            parent[dest] = src;//record the shortest path
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
    //n is number of vertex
    public void bellmanford(Edge[] edges, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                relax(Integer.parseInt(e.src), Integer.parseInt(e.dest), e.weight);
            }
        }
    }

}



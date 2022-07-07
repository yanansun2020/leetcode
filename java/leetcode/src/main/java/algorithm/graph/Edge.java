package algorithm.graph;

public class Edge {
    int weight;
    String src;
    String dest;
    Edge(){}
    Edge(String start, String dest, int weight){
        this.src = start;
        this.dest = dest;
        this.weight = weight;
    }
}

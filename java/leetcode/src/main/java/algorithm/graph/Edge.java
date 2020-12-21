package algorithm.graph;

public class Edge {
    int weight;
    String start;
    String end;
    Edge(){}
    Edge(String start, String end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

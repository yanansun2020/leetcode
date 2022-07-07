package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphUtil {
    public static Map<String, List<Vertex> > directed_matrixToList(List<Edge> edges){
        Map<String, List<Vertex> > vertexListMap = new HashMap<>();
        for (Edge edge : edges) {
            Vertex end_vertex = new Vertex();
            end_vertex.name = edge.dest;
            end_vertex.distance = edge.weight;
            List<Vertex> adjancent = vertexListMap.get(edge.src);
            if (adjancent == null) {
                adjancent = new ArrayList<>();
            }
            adjancent.add(end_vertex);
            vertexListMap.put(edge.src, adjancent);
        }
        return vertexListMap;
    }
}

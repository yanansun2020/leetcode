package algorithm.graph;

import java.util.Objects;

public class Vertex {
    String name;
    public Vertex path;
    public boolean is_visited;
    int distance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}

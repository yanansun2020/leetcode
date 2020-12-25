package algorithm.graph;

/**
 * Find all pairs shortest path
 * Try all intermediate nodes
 * Try for all possible starting position
 * Try for all possible ending position
 */
public class FloydWarshallalgorithm {
    void floyd_warshall(int[][] graph) {
        int rows = graph.length;
        int cols = graph[0].length;
        int[][] dist = new int[rows][cols];
        //Assign all values of graph to allPairs_SP
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                dist[i][j] = graph[i][j];
            }
        }
        //Find all pairs shortest path by trying all possible paths
        //SKIP if K is unreachable from i or j is unreachable from k
        for(int k=0; k<rows; ++k){
            for(int i=0; i<rows; ++i){
                for(int j=0;j<cols;++j) {
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)
                        continue;
                    //Check if new distance is shorter via vertex K
                    if(dist[i][k]+dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        //Check for negative edge weight cycle
        for(int i=0;i<rows;++i){
            if(dist[i][i] < 0){
                return;
            }
        }
        //Print Shortest Path Graph
        //(Values printed as INT_MAX defines there is no path)
        for(int i=1;i<rows;++i) {
            for(int j=0;j<rows;++j){
                System.out.println(i + " to " + j + " distance is " + dist[i][j] + "\n");
            }
        }
    }
}

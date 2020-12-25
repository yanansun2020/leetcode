package graph;

import org.junit.Test;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        init_distance(edges, distance, n);
        // when goed through k
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(distance[i][k]==Integer.MAX_VALUE || distance[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    if(distance[i][k]+distance[k][j] < distance[i][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        int[] reachableCity = new int[n];
        for (int i = 0; i < n; i++) {
            int numberReachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    numberReachable++;
                }
            }
            reachableCity[i] = numberReachable;
        }
        int cityNumber = 0;
        int minReachable = Integer.MAX_VALUE;
        int minReachable1 = Integer.MAX_VALUE;
        for (int i= 0; i < n; i++) {
            if(reachableCity[i] == 0) {
                minReachable1 = i;
                continue;
            }
            if (reachableCity[i] <= minReachable) {
                minReachable = reachableCity[i];
                cityNumber = i;
            }
        }
        return minReachable1 <Integer.MAX_VALUE? minReachable1: cityNumber;
    }

    private void init_distance(int[][] edges, int[][] distance, int n){
        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (distance[i][j] == 0 && i != j) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    @Test
    public void test(){
        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int city = findTheCity(4, edges, 4);
        edges = new int[][]{{0,3,7},{2,4,1},{0,1,5},{2,3,10},{1,3,6},{1,2,1}};
        city = findTheCity(6, edges, 417);
    }
}

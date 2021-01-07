package greedy;

import java.util.Arrays;

/**
 * measure the benefit while choosing city1 than city2
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2)->(o2[1] - o2[0]) - (o1[1] - o1[0]));
        int n = costs.length/2;
        int totalcost = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < n) {
                totalcost += costs[i][0];
            } else {
                totalcost += costs[i][1];
            }
        }
        return totalcost;
    }
}

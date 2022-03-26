package sort;

import java.util.Arrays;

public class MaximumEarningsFromTaxi {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (o1, o2)->o1[1] == o2[1]? o1[0] - o2[0] : o1[1] - o2[1]);
        return 0l;
    }
}

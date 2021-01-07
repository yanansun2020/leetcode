package greedy;

/**
 * https://www.youtube.com/watch?v=nTKdYm_5-ZY&list=PLupD_xFct8mETlGFlLVrwbLwcxczbgWRM&index=8&t=0s
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0;
        int deficit = 0;
        int startPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            if (surplus + gas[i] < cost[i]) {
                startPoint++;
                deficit += surplus;
            } else {
                surplus += gas[i] - cost[i];
            }
        }
        return surplus + deficit >=0  ? startPoint : -1;
    }
}

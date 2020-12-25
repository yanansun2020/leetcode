package graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Find next legal one then swap
 */
public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> indexMap = getIndexMap(row);
        int numOfSwap = 0;
        for (int i = 0; i < row.length - 1; i += 2) {
            int num = row[i];
            int numNeed = num + 1;
            if (num%2 == 1) {
                numNeed = num - 1;
            }
            int next = row[i + 1];
            if (numNeed == next) {
                continue;
            }
            int numNeedIndex = indexMap.get(numNeed);
            row[numNeedIndex] = next;
            row[i + 1] = numNeed;
            indexMap.put(numNeed, i + 1);
            indexMap.put(next, numNeedIndex);
            numOfSwap++;
        }
        return numOfSwap;
    }
    Map<Integer, Integer> getIndexMap(int[] row){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }
        return map;
    }

    @Test
    public void test(){
        int[] row = new int[]{0, 2, 1, 3};
        int ans = minSwapsCouples(row);
    }
}

package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SockPair {
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< n; i++) {
            Integer value = map.get(ar[i]);
            if (value == null) {
                value = 0;
            }
            map.put(ar[i], value + 1);
        }
        int ocunt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ocunt += entry.getValue()/2;
        }
        return ocunt;
    }

}

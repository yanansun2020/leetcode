package greedy;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisiblebyk {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            int mod = a % k;
            mod = (mod + k) % k;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        if (map.get(0) != null && map.get(0)%2 == 1) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            Integer a = map.get(i);
            Integer b = map.get(k - i);
            if (a == null && b == null) {
                continue;
            }
            if (a != null && b != null && a.compareTo(b) == 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

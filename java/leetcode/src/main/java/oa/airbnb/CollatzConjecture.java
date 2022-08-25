package oa.airbnb;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CollatzConjecture {
    Map<Integer, Integer> map = new HashMap<>();
    private int findSteps(int num) {
        if (num <= 1) return 1;
        if (map.containsKey(num)) return map.get(num);
        if (num % 2 == 0) return 1 + findSteps(num / 2);
        return 1 + findSteps(3 * num + 1);
    }

    public int findLongestSteps(int num) {
        if (num < 1) return 0;
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int t = findSteps(i);
            map.put(i, t);
            res = Math.max(res, t);
        }
        return res;
    }

    @Test
    public void test() {

    }
}

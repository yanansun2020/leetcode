package oa.ms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
//The optimum way is moving Rs to the middle of the row.
public class GroupRedBalls {
    public int minAdjSwapRedBalls(String s) {
        List<Integer> redIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                redIndex.add(i);
            }
        }
        int res = 0, mid = redIndex.size() / 2;  // mid is the point to get minimum swaps; greedy.
        for (int i = 0; i < redIndex.size(); i++) {
            res += Math.abs(redIndex.get(mid) - redIndex.get(i)) - Math.abs(mid - i);
        }
        return res;
    }
    @Test
    public void test() {
        String s = "WRRWWR";
        System.out.println(minAdjSwapRedBalls(s));
        s = "WWRWWWRWR";
        System.out.println(minAdjSwapRedBalls(s));
        s = "WR";
        System.out.println(minAdjSwapRedBalls(s));
        s = "RWWWRWRWWR";
        System.out.println(minAdjSwapRedBalls(s));
    }
}

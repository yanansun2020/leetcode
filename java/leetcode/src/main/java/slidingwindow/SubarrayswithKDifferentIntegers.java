package slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * number of subarray with at most k unique elements
 * minus(-)
 * number of subarray with at most k-1 unique elements
 */
public class SubarrayswithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int at_most_k = at_most_k(A, K);
        int at_most_k_minus_one = at_most_k(A, K -1);
        return at_most_k - at_most_k_minus_one;
    }
    public int at_most_k(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        for (; right < A.length; right++) {
            Integer ele = A[right];
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            while (map.size() > K) {
                Integer left_ele = A[left];
                map.put(left_ele, map.get(left_ele) - 1);
                if (map.get(left_ele) <= 0) {
                    map.remove(left_ele);
                }
                left++;
            }
            count += (right + 1 - left);
        }
        return count;
    }
    @Test
    public void test(){
        int[] A = new int[]{1,2,1,2,3};
        int res = subarraysWithKDistinct(A, 2);
        A = new int[]{1,2,1,3,4};
        res = subarraysWithKDistinct(A, 3);
    }
}

package oa.amazon.ftoa;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ATest2 {
    private static int binSearch(List<Integer> prices, Integer target){
        int left = 0;
        int right = prices.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prices.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
    @Test
    public void test(){
        Integer[] nums = new Integer[]{1, 2, 3,3,5};
        List<Integer> ss = Arrays.asList(nums);
        int s = binSearch(ss, 3);
    }
}

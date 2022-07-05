package oa.ms;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestK {

    private int getLargestK(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >=0 && arr[i] > 0; i--) {
            if (set.contains(-1 * arr[i])) {
                return arr[i];
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] arr = {3, 2, -2, 5, -3};
        System.out.println(getLargestK(arr));
        arr = new int[]{1,2,3,-4};
        System.out.println(getLargestK(arr));
    }
}

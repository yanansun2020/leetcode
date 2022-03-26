package algorithm.sort;

import org.junit.Test;

/**
 * suppose n elements ine arrat are between [0, k]
 */
public class CountingSort {
    public void sort(int[] arr, int[] res, int k) {
        int[] countArray = new int[k + 1];
        int n = arr.length;
        //count number of occurrence
        for (int i = 0; i < n; i++) {
            countArray[arr[i]]++;
        }
        //number of elements <= index_i
        for (int i = 1; i <= k; i++) {
            countArray[i] += countArray[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int v = arr[i];
            int numEleLessOrEqualV = countArray[v];
            res[numEleLessOrEqualV - 1] = v;
            countArray[v]--;
        }
    }
    @Test
    public void test() {
        int[] arr = new int[]{2, 5, 3, 0, 2,3,0,3};
        int[] B = new int[arr.length ];
        sort(arr, B, 5);
    }
}

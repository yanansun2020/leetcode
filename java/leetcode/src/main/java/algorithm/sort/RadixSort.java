package algorithm.sort;

import org.junit.Test;

/**
 * come from counting sort
 * from the least significant digit to the most
 * view each digit as the key for counting sort
 * Watch out the way to get each digit
 */
public class RadixSort {
    public void radixSort(int[] arr) {
        int maxValue = getMx_value(arr);
        for (int exp = 1; maxValue /exp > 0; exp *= 10) {
            counting_sort(arr, 9, exp);
        }
    }
    private void counting_sort(int[] arr, int k, int exp) {
        int[] C = new int[k + 1];
        int n = arr.length;
        //count number of occurrence
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int cur_digit = get_cur_digit(arr[i], exp);
            C[cur_digit]++;
        }
        //number of elements <= index_i
        for (int i = 1; i <= k; i++) {
            C[i] += C[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int v = arr[i];
            int cur_digit = get_cur_digit(v, exp);
            int numEleLessOrEqualV = C[cur_digit];
            res[numEleLessOrEqualV - 1] = v;
            C[cur_digit]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }

    private int getMx_value(int[] arr) {
        int max_value = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max_value) {
                max_value = arr[i];
            }
        }
        return max_value;
    }

    private int get_cur_digit(int value, int exp) {
        return (value/exp) % 10;
    }

    @Test
    public void test() {
        int[] arr = new int[] {329, 457, 657, 839, 436, 720, 355};
        radixSort(arr);
    }
}

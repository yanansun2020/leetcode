package algorithm.sort;

import org.junit.Test;

/**
 * time complexity: O(N^2)
 */
public class InsertionSort {
    public void insertionSort(int[] arr){
        int j;
        for (int i = 1; i<arr.length; i++) {
            Integer tmp = arr[i];
            for (j = i - 1; j >=0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
    }
    @Test
    public void test() {
        int[] arr = new int[]{5, 2,4,6,1,3};
        insertionSort(arr);
    }
}

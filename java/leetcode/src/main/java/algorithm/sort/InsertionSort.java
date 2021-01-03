package algorithm.sort;

/**
 * time complexity: O(N^2)
 */
public class InsertionSort {
    public void insertionSort(Integer[] arr){
        int j;
        for (int i = 1; i<arr.length; i++) {
            Integer tmp = arr[i];
            for (j = i; j >0 && tmp.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }
}

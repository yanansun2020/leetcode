package algorithm.sort;

import org.junit.Test;

/**
 * time complexity:
 * worst : O(N2)
 * best: O(NlogN)
 */
public class QuickSort {
    int CUTOFF;
    public void quickSort(Integer[] arr){
        CUTOFF = 2;
        quickSort(arr, 0, arr.length - 1);
    }

    void quickSort(Integer[] arr, int left, int right){
        if (left + CUTOFF < right) {
            Integer pivot = median3(arr, left, right);
            int i = left;
            int j = right - 1;
            for (;;) {
                while (i < arr.length -1 && arr[++i] .compareTo(pivot) < 0) {}
                while (j >0 && arr[--j] .compareTo(pivot) > 0) {}
                if (i < j) {
                    swapReferences(arr, i, j);
                } else {
                    break;
                }
            }
            swapReferences(arr, i, right -1);
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        } else {
            insertionSort(arr, left, right);
        }
    }

    /**
     * 3 数中值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    Integer median3(Integer[] arr, int left, int right){
        int center = left + (right - left)/2;
        if (arr[center].compareTo(arr[left]) < 0) {
            swapReferences(arr, left, center);
        }
        if (arr[right].compareTo(arr[left]) < 0) {
            swapReferences(arr, left, right);
        }
        if (arr[right].compareTo(arr[center]) < 0) {
            swapReferences(arr, center, right);
        }
        swapReferences(arr, center, right - 1);
        return arr[right - 1];
    }

    void swapReferences(Integer[] arr, int i, int j){
        Integer tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    void insertionSort(Integer[] arr, int left, int right){
        int j;
        for (int i = left + 1; i<= right; i++) {
            Integer tmp = arr[i];
            for (j = i; j >0 && tmp.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }

    @Test
    public void test(){
        Integer[] arr = new Integer[]{8,1,4,9,0,3,5,2,7,6};
        quickSort(arr);
    }
}

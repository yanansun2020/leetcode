package algorithm.sort;

import org.junit.Test;

/**
 * idea: find a pivot, all the find all elements less than it and all elements greater than it
 * time complexity:
 * worst : O(N2)
 * best: O(NlogN)
 */
public class QuickSort {
    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length);
    }

    void quickSort(int[] arr, int left, int right){
        if (left >= right) {
            return;
        }
        int index = partition(left, right, arr);
        quickSort(arr, left, index);
        quickSort(arr, index + 1, right);
    }

    /**
     * find the correct index of pivot value
     * @param left
     * @param right
     * @param arr
     * @return
     */
    private int partition(int left, int right, int[] arr) {
        int i = left, j = right;
        int pivot = getPivot(arr, left, right);
        while (i < j) {
            do {
                i++;
            } while (i < j && arr[i] < pivot);

            do {
                j--;
            } while (j >= 0 && arr[j] > pivot);

            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    private int getPivot(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int value = arr[mid];
        swap(arr, left, mid);
        return value;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{3,2,1,1, 5,6,4, 3, 5,7, 3, 8};
        arr = new int[]{5,7,2,4,8,1,3};
        quickSort.quickSort(arr);
    }
}

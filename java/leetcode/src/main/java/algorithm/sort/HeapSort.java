package algorithm.sort;

import org.junit.Test;

/**
 * step1. build max heap from right side to the leftside-> heapify, see build_max_heap and build_max_heap_bottom_up
 * step2: switch the first element with the last, heapify again.
 */
public class HeapSort {
    @Test
    public void test() {
        int[] arr = new int[]{4,1,3,2, 16, 9, 10,14, 8, 7};
//        build_max_heap(arr);
        //arr = new int[]{12, 11, 13,5,6,7};
        //int[] res = build_max_heap_bottom_up(arr);
        heapSort(arr);
        System.out.print(arr);
    }

    private void heapSort(int[] arr) {
        int n = arr.length;
        heapify(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i);
        }
    }

    private void heapify(int[] arr, int index) {
        for(int i = index/2 - 1; i >= 0; i--){
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < index && arr[i] < arr[l]) {
                swap(arr, i, l);
            }
            if (r < index && arr[i] < arr[r]) {
                swap(arr, i, r);
            }
        }
    }




//===code below need to revisit===

    public void heap_sort(int[] arr) {
        build_max_heap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            top_down_max_heapify(arr, i, 0);
        }
    }

    /**
     * build heap top down
     * @param arr
     */
    public void build_max_heap(int[] arr) {
        for (int i = arr.length/2; i >= 0; i--) {
            top_down_max_heapify(arr, arr.length, i);
        }
    }

    /**
     * build heap bottom up
     * @param arr
     * @return
     */
    public int[] build_max_heap_bottom_up(int[] arr) {
        int[] res = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            res[j] = arr[i];
            bottom_up_max_heapify(res, j);
            j++;
        }
        return res;
    }

    private void bottom_up_max_heapify(int[] arr, int i) {
        int parent_index = (i - 1)/2;
        if (parent_index >= 0 && arr[parent_index] < arr[i]) {
            swap(arr, i, parent_index);
            bottom_up_max_heapify(arr, parent_index);
        }
    }

    /**
     * create max heap top down
     * @param arr
     * @param n
     * @param i
     */
    private void top_down_max_heapify(int[] arr, int n,  int i) {
        int left_child_index = (i << 1) + 1;
        int right_child_index = (i << 1) + 2;
        int largest_value_index = i;
        if (left_child_index < n) {
            int left_child = arr[left_child_index];
            if (arr[i] < left_child) {
                largest_value_index = left_child_index;
            } else {
                largest_value_index = i;
            }
        }
        if (right_child_index < n) {
            int right_child = arr[right_child_index];
            if (right_child > arr[largest_value_index]) {
                largest_value_index = right_child_index;
            }
        }
        if (largest_value_index != i) {
            swap(arr, i, largest_value_index);
            top_down_max_heapify(arr, n, largest_value_index);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

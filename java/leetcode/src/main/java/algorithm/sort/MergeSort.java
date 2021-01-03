package algorithm.sort;

/**
 * worst time complexity: O(logn)
 */
public class MergeSort {
    public void mergeSort(Integer[] arr){
        Integer[] tmpArr = new Integer[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }
    public void mergeSort(Integer[] arr, Integer[] tmparr, int left, int right){
        while (left < right) {
            int middle = left + (right - left)/2;
            mergeSort(arr, tmparr, left, middle);
            mergeSort(arr, tmparr, middle + 1, right);
        }
    }
    public void merge(Integer[] arr, Integer[] tmparr, int left, int middle, int right){
        int leftEnd = middle -1;
        int tmpPosition = left;
        int numEles = right - left + 1;
        while (left <= leftEnd && middle <= right) {
            if (arr[left].compareTo(arr[middle]) <= 0) {
                tmparr[tmpPosition++] = arr[left++];
            } else {
                tmparr[tmpPosition++] = arr[middle++];
            }
        }
        while (left <= leftEnd) {
            tmparr[tmpPosition++] = arr[left++];
        }
        while (middle <= right) {
            tmparr[tmpPosition++] = arr[middle++];
        }
        for (int i = 0; i < numEles; i++, right--) {
            arr[right] = tmparr[right];
        }
    }
}

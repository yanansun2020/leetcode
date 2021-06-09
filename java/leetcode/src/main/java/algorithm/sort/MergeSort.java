package algorithm.sort;

/**
 * worst time complexity: O(nlogn)
 */
public class MergeSort {

    public void mergeSort(int[] arr){
        int[] res = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, res);
    }

    public void mergeSort(int[] arr, int left, int right, int[] res){
        if (left < right) {
            int middle = left + (right - left)/2;
            mergeSort(arr, left, middle, res);
            mergeSort(arr, middle + 1, right, res);
            merge(left, middle, right, arr, res);
        }
    }

    public void merge(int left, int middle, int right, int[] arr, int[] res) {
        int i = left, j = middle + 1 , k = left;
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                res[k++] = arr[i++];
            } else {
                res[k++] = arr[j++];
            }
        }
        while (i <= middle) {
            res[k++] = arr[i++];
        }
        while (j <= right) {
            res[k++] = arr[j++];
        }
        i = left;
        while (i <= right) {
            arr[i] = res[i];
            i++;
        }
    }
   

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{9, 3, 7, 5};
        mergeSort.mergeSort(arr);
    }

     /**
     * 2-way merging
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] merge(int[] arr1, int[] arr2){
        int i = 0, j = 0, k = 0;
        int[] res = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            res[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            res[k++] = arr2[j++];
        }
        return res;
    }
}

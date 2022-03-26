package algorithm.sort;

/**
 * find kth largest/smallest value
 */
public class QuickSelect {
    public int quickSelect(int[] arr, int k){
        int index = quickSelect(arr, 0, arr.length, k);
        return arr[index];
    }

    int quickSelect(int[] arr, int left, int right, int k){
        if (left == right) {
            return left;
        }
        int index = partition(left, right, arr);
        if (k < index) {
            return quickSelect(arr, left, index, k);
        } else if (k > index){
            return quickSelect(arr, index + 1, right, k);
        }
        return index;
    }

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
        QuickSelect quickSort = new QuickSelect();
        int[] arr = new int[]{1,8};
        int a = quickSort.quickSelect(arr, 1);
    }
}

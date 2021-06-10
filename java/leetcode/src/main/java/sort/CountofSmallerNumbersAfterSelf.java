package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountofSmallerNumbersAfterSelf {
    //segment tree approach
    public List<Integer> countSmaller(int[] nums) {
        return null;
    }
    //segment tree approach end
    //below is merge sort approach
    public List<Integer> countSmaller_merge_sort(int[] nums) {
        Item[] items = getList(nums);
        Item[] sorted = new Item[nums.length];
        int[] count = new int[nums.length];
        mergeSort(items, 0, nums.length - 1, sorted, count);
        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }
    
    void mergeSort(Item[] items, int left, int right, Item[] sorted, int[] count) {
        if (left >= right) return;
        int mid = left + (right - left)/2;
        mergeSort(items, left, mid, sorted, count);
        mergeSort(items, mid + 1, right, sorted, count);
        for (int i = left; i <= mid; i++) {
            int lowerItems = getLowerBound(i, mid + 1, right, items);
            count[items[i].index] += lowerItems;
        }
        merge(items, left, mid, right, sorted);
    }
    
    private void merge(Item[] items, int left, int mid, int right, Item[] sorted) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (items[i].value < items[j].value) {
                sorted[k++] = items[i++];
            } else {
                sorted[k++] = items[j++];
            }
        }
        while (i <= mid) {
            sorted[k++] = items[i++];
        }
        while (j <= right) {
            sorted[k++] = items[j++];
        }
        i = left;
        while (i <= right) {
            items[i] = sorted[i];
            i++;
        }
    }
    
    private int getLowerBound(int left, int mid, int right, Item[] items) {
        int value = items[left].value;
        int i = mid, j = right;
        while (i <= j) {
            int m = i + (j - i)/2;
            if (items[m].value >= value) {
                j = m -1;
            } else {
                i = m + 1;
            }
        }
        return i - mid;
    }
    // merge sort approach ended
    
    private Item[] getList(int[] nums) {
        Item[] numsList = new Item[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsList[i] = new Item(nums[i], i);
        }
        return numsList;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        CountofSmallerNumbersAfterSelf smaller = new CountofSmallerNumbersAfterSelf();
        List<Integer> res = smaller.countSmaller(arr);
        arr = new int[]{-1};
        res = smaller.countSmaller(arr);
        arr = new int[]{-1, -1};
        res = smaller.countSmaller(arr);
        System.out.println(res);
    }
}


class Item {
    int value;
    int index;
    Item(int value, int index) {
        this.value = value;
        this.index = index;
    }
}


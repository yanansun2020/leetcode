package algorithm.bisearch;

import java.util.ArrayList;

public class BinarySearch {
    /**
     * [1, 5, 7] 3 => return index 0
     *
     * @param list
     * @param target
     * @return the left side boundry
     */
    private int bisearch_leftbound(int[] list, int target) {
        int left = 0, index = -1;
        int right = list.length - 1;
        while (left <= right) {
            int middle = left + (right - left)/2;
            Integer vt = list[middle];
            if (target > vt) {
                left = middle + 1;
            } else {
                index = middle;
                right = middle - 1;
            }
        }
        return index;
    }

    private int bisearch_rightbound(int[] list, int target) {
        int left = 0, index = -1;
        int right = list.length - 1;
        while (left <= right) {
            int middle = left + (right - left)/2;
            Integer vt = list[middle];
            if (target >= vt) {
                index = middle;
                left = middle + 1;
            } else {
                right = middle - 1;

            }
        }
        return index;
    }

    //find the first element greater than num without repeat numbers
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (sub.get(mid) == num) {
                return mid;
            }
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    private int find_correct_location(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (sub.get(mid) == num) {
                return mid;
            }
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,5,5, 5, 9};
        BinarySearch leftBound = new BinarySearch();
        int index = leftBound.bisearch_rightbound(arr, 5);
        int index2 = leftBound.bisearch_leftbound(arr, 5);
    }
}

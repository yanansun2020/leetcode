package oa.ms;

public class JumpGame {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] >= arr.length) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        int move = arr[start];
        arr[start] = arr.length;
        return canReach(arr, start - move) || canReach(arr, start + move);
    }
}

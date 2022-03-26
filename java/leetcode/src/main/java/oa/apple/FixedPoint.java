package oa.apple;

public class FixedPoint {
    public int findFixedPoint(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int m = l + (r - l)/2;
            if (array[m] == m) {
                return m;
            }
            if (array[m] < m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}

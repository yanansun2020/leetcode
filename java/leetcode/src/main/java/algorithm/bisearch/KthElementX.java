package algorithm.bisearch;

public class KthElementX {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = n * m;
        while (left < right) {
            int mid = left + (right - left)/2;
            int length = len(mid, m, n);
            if( length < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int len(int mid, int m, int n) {
        int res = 0;
        for (int l = 1; l <= m; l++) {
            res += Math.min(n, mid/l);
        }
        return res;
    }
}

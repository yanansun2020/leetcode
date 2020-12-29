package algorithm.tree;

import java.util.Arrays;

/**
 * Indexed tree
 * used for range sum query.
 * Difference between DP is that DP requires the array not change, if mutable
 * Time complexity of DP is O(n), but this method is O(logn)
 * update O(logn)
 * query O(logn)
 */
public class FenwickTree {
    int[] sums;
    public FenwickTree(int n){
        sums = new int[n + 1];
        Arrays.fill(sums, 0);
    }
    public void update(int i, int delta){
        while (i < sums.length) {
            sums[i] += delta;
            i += lowbit(i);
        }
    }
    public int query(int i){
        int sum = 0;
        while (i > 0) {
            sum += sums[i];
            i -= lowbit(i);
        }
        return sum;
    }
    private int lowbit(int x){
        return x & (-x);
    }
    public static void main(String[] args){
        FenwickTree fenwickTree = new FenwickTree(5);
        fenwickTree.update(1, 2);
    }
}

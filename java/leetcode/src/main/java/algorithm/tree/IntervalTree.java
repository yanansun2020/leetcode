package algorithm.tree;

import org.junit.Test;

/**
 * Consider a situation where we have a set of intervals and we need following operations to be implemented efficiently
 *                 [15,20]40
 *                 /    \
 *       [10, 30]30      [17,19]40
 *        /      \           \
 *   [5,20]20  [12,15]15     [30, 40]40
 *
 *
 */
public class IntervalTree {
    public TreeNode insert(TreeNode root, int[] interval){
        if (root == null) {
            TreeNode node = new TreeNode(interval);
            node.max = interval[1];
            return node;
        }
        int low = root.interval[0];
        if (interval[0] < low) {
            root.left = insert(root.left, interval);
        } else {
            root.right = insert(root.right, interval);
        }
        if (root.max < interval[1]){
            root.max = interval[1];
        }
        return root;
    }

    public boolean isOverlap(int[] interval1, int[] interval2){
        if (interval1[0] <= interval2[1] && interval2[0] <= interval1[1])
            return true;
        return false;
    }
    public int[] overlapSearch(TreeNode root, int[] i) {
        // Base Case, tree is empty
        if (root == null) return null;

        // If given interval overlaps with root
        if (isOverlap(root.interval, i)){
            return root.interval;
        }
        // If left child of root is present and max of left child is
        // greater than or equal to given interval, then i may
        // overlap with an interval is left subtree
        if (root.left != null && root.left.max >= i[0])
            return overlapSearch(root.left, i);

        // Else interval can only overlap with right subtree
        return overlapSearch(root.right, i);
    }
    @Test
    public void test(){
        int[][] ints = new int[][]{{15, 20}, {10, 30}, {17, 19},
            {5, 20}, {12, 15}, {30, 40}
        };
        TreeNode root = null;
        for (int i = 0; i < ints.length; i++)
             root = insert(root, ints[i]);
        int[] res = overlapSearch(root, new int[]{6,7});
    }
}

class Interval{
    int low;
    int high;
    Interval(){}
    Interval(int low, int high){
        this.low = low;
        this.high = high;
    }
}
class TreeNode{
    int[] interval;
    int max;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int[] interval){
        this.interval = interval;
    }
}

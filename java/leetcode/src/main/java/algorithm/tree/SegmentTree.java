package algorithm.tree;

/**
 * Find the sum of elements from index l to r where 0 <= l <= r <= n-1
 * Used for mutable array range query
 */
public class SegmentTree {
    int start;
    int end;
    int sum;
    SegmentTree left;
    SegmentTree right;
    public SegmentTree(){}
    public SegmentTree(int start, int end, int sum, SegmentTree left, SegmentTree right){
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = left;
        this.right = right;
    }

    public static SegmentTree buildTree(int start, int end, int[] nums){
        if (start == end) {
            return new SegmentTree(start, end, nums[start], null, null);
        }
        int middle = start + (end - start)/2;
        SegmentTree left = buildTree(start, middle, nums);
        SegmentTree right = buildTree(middle + 1, end, nums);
        return new SegmentTree(start, end, left.sum + right.sum, left, right);
    }
    public static void updateTree(int index, int value, SegmentTree root){
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        int middle = root.start + (root.end - root.start)/2;
        if (index <= middle) {
            updateTree(index, value, root.left);
        } else {
            updateTree(index, value, root.right);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    public static int sumRange(SegmentTree root, int start, int end){
        if (start == root.start && end == root.end) {
            return root.sum;
        }
        int middle = root.start + (root.end - root.start)/2;
        if (end <= middle) {
            return sumRange(root.left, start, end);
        }
        if (start > middle) {
            return sumRange(root.right, start, end);
        }
        return sumRange(root.left, start, middle) + sumRange(root.right, middle+ 1, end);
    }

}

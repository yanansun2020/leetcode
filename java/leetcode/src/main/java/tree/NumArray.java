package tree;

import algorithm.tree.FenwickTree;

public class NumArray {
    FenwickTree fenwickTree;
    int[] nums;
    public NumArray(int[] nums) {
        fenwickTree = new FenwickTree(nums.length + 1);
        for (int i = 0; i < nums.length; i++) {
            fenwickTree.update(i + 1, nums[i]);
        }
        this.nums = nums;
    }

    public void update(int i, int val) {
        fenwickTree.update(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
       return fenwickTree.query(j + 1) - fenwickTree.query(i);
    }

    /*below is segment tree implement
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        if(nums != null && nums.length > 0){
            root = SegmentTreeNode.buildTree(0, nums.length - 1, nums);
        }
    }

    public void update(int i, int val) {
        SegmentTreeNode.updateTree(i, val, root);
    }

    public int sumRange(int i, int j) {
        return SegmentTreeNode.sumRange(root, i, j);
    }*/

    public static void main(String[] args){
        int[] nums = {1, 3, 5};
        NumArray array = new NumArray(nums);
        int ans = array.sumRange(0, 2);
        array.update(1, 2);
        ans = array.sumRange(0, 2);
    }
}


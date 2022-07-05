package oa.ms;

import tree.TreeNode;

import java.util.Set;
//https://leetcode.com/discuss/interview-question/1065005/Max-Number-of-Distinct-Notes-along-a-Root-Node-Path
public class DistinctNode {
    private static int traverse(TreeNode root, Set<Integer> mSet) {

        if (root == null || mSet.contains(root.val)) {
            return mSet.size();
        }

        //Add the root to the set
        mSet.add(root.val);
        int l = traverse(root.left, mSet);
        int r = traverse(root.right, mSet);
        //Backtrack and remove the element from the set
        mSet.remove(root.val);

        //return the max path
        return Math.max(l, r);
    }

}

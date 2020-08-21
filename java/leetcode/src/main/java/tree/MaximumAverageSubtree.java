package tree;

import org.junit.Test;

public class MaximumAverageSubtree {
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null){
            return 0.0D;
        }
        return helper(root).average;
    }

    public AverageTree helper(TreeNode node){
        if(node == null){
            return new AverageTree(0, 0, 0, node);
        }
        if(node.left == null && node.right == null){
            return new AverageTree(1, node.val, node.val, node);
        }
        AverageTree left = helper(node.left);
        AverageTree right = helper(node.right);
        int tmpSum = 0;
        int tmpNodeNumber = 0;
        tmpSum += left.sum;
        tmpSum += right.sum;
        tmpSum += node.val;
        tmpNodeNumber += left.numNodes;
        tmpNodeNumber += right.numNodes;
        tmpNodeNumber += 1;
        double tmpAvg = (double)tmpSum/tmpNodeNumber;
        AverageTree max = left;
        if(left.average<right.average){
            max = right;
        }
        if(tmpAvg > max.average){
            return new AverageTree(tmpNodeNumber, tmpAvg, tmpSum, node);
        }
        return new AverageTree(tmpNodeNumber, max.average, tmpSum, node);
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(4, new TreeNode(3, new TreeNode(0), new TreeNode(2)), new TreeNode(1));
        double ss = maximumAverageSubtree(root);
    }
}
class AverageTree{
    int numNodes;
    double average;
    int sum;
    TreeNode node;
    AverageTree(){}
    AverageTree(int numNodes, double average, int sum, TreeNode node){
        this.numNodes = numNodes;
        this.average = average;
        this.sum = sum;
        this.node = node;
    }
}

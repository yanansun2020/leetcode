package tree;

import java.util.LinkedList;

/**
 * build binary node by array
 * node.left = buildTree(nums, node, 2 * i + 1);
 * node.right = buildTree(nums, node, 2 *i + 2);
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
    public static Node buildTree(Integer[] nums, int i){
        if (i >= nums.length || nums[i] == null) {
            return null;
        }
        Node node = new Node(nums[i]);
        node.left = buildTree(nums, 2 * i + 1);
        node.right = buildTree(nums, 2 *i + 2);
        return node;
    }
    public Node buildTree(Integer[] nums){
        Node root = null;
        if (nums == null || nums.length == 0) {
            return root;
        }
        LinkedList<Node> nodeList = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            if (root == null) {
                root = new Node(nums[i]);
                nodeList.addLast(root);
                i++;
                continue;
            }
            Node topEle = nodeList.removeFirst();
            if (nums[i] != null) {
                Node left = new Node(nums[i]);
                topEle.left = left;
                nodeList.addLast(left);
            }
            i++;
            if (nums[i] != null) {
                Node right = new Node(nums[i]);
                topEle.right = right;
                nodeList.addLast(right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args){
        Integer[] nums = new Integer[]{1,2,3,null, null, 4,5};
        Node node = new Node();
        Node root = node.buildTree(nums, 0);
    }
}


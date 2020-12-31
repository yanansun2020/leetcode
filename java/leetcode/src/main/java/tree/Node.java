package tree;

import java.util.ArrayList;
import java.util.List;


public class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
//    public static Node buildTree(Integer[] nums, int i){
//        if (i >= nums.length || nums[i] == null) {
//            return null;
//        }
//        Node node = new Node(nums[i]);
//        node.left = buildTree(nums, 2 * i + 1);
//        node.right = buildTree(nums, 2 *i + 2);
//        return node;
//    }
//    public Node buildTree(Integer[] nums){
//        Node root = null;
//        if (nums == null || nums.length == 0) {
//            return root;
//        }
//        LinkedList<Node> nodeList = new LinkedList<>();
//        int i = 0;
//        while (i < nums.length) {
//            if (root == null) {
//                root = new Node(nums[i]);
//                nodeList.addLast(root);
//                i++;
//                continue;
//            }
//            Node topEle = nodeList.removeFirst();
//            if (nums[i] != null) {
//                Node left = new Node(nums[i]);
//                topEle.left = left;
//                nodeList.addLast(left);
//            }
//            i++;
//            if (nums[i] != null) {
//                Node right = new Node(nums[i]);
//                topEle.right = right;
//                nodeList.addLast(right);
//            }
//            i++;
//        }
//        return root;
//    }
    public static void main(String[] args){

    }
}


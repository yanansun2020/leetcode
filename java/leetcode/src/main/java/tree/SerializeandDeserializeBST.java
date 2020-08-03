package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//
//  Definition for a binary tree node.
class TreeNode {
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> strList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                strList.add(node.val + "");
                if(node.left != null){
                    queue.offer(node.left);
                }else{
                    queue.offer(null);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }else{
                    queue.offer(null);
                }
            }else{
                strList.add("null");
            }
        }
        StringBuilder sb = new StringBuilder();
        int end_index = 0;
        for(int i = strList.size() -1; i >=0; i--){
            if(strList.get(i) != "null") {
                end_index = i;
                break;
            }
        }
        for(int i =0 ; i <=end_index; i++ ){
            sb.append(strList.get(i)).append(" ");
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data == ""){
            return null;
        }
        String[] nodesValue = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodesValue[0]));
        queue.offer(root);
        int i =1 ;
        while(i < nodesValue.length){
            TreeNode node = queue.poll();
            if(!nodesValue[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(nodesValue[i]));
                queue.offer(node.left);
            }
            if(i + 1 < nodesValue.length && !nodesValue[i+1].equals("null")){
                node.right = new TreeNode(Integer.parseInt(nodesValue[i+1]));
                queue.offer(node.right);
            }
            i += 2;
        }
        return root;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
        String s = serialize(root);
        TreeNode node = deserialize(s);
    }
}

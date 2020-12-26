package graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A valid tree must have nodes with only one parent and exactly one node with no parent.
 */
public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        Set<Integer> pSet = findRoot(n, leftChild, rightChild);
        if (pSet.size() != 1) {
            return false;
        }
        int[] visited = new int[n];
        boolean tmp = find_parent((int)pSet.toArray()[0], parents, -1, leftChild, rightChild, visited);
        if (!tmp){
            return false;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                count++;
            }
        }
        return count == n;
    }
    Set<Integer> findRoot(int n, int[] leftChild, int[] rightChild){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            set.remove(leftChild[i]);
            set.remove(rightChild[i]);
        }
        return set;
    }
    boolean find_parent(int i, int[] parents, int parent, int[] left, int[] right, int[] visited) {
        if(i == -1) {
            return true;
        }
        int leftNode = left[i];
        int rightNode = right[i];
        if (visited[i] == 1) {
            return false;
        }
        if (parents[i] > -1) {
            return true;
        }
        visited[i] = 1;
        parents[i] = parent;
        boolean find_left = find_parent(leftNode, parents, i, left, right, visited);
        if (!find_left) {
            return false;
        }
        boolean find_right = find_parent(rightNode, parents, i, left, right, visited);
        return find_right;
    }

    @Test
    public void test(){
        int[] leftChild = new int[]{1,-1,3,-1};
        int[] rightChild = new int[]{2,3,-1,-1};
        boolean ans = validateBinaryTreeNodes(4, leftChild, rightChild);
        leftChild = new int[]{1,-1,3,-1};
        rightChild = new int[]{2,-1,-1,-1};
        ans = validateBinaryTreeNodes(4, leftChild, rightChild);
        leftChild = new int[]{1,0};
        rightChild = new int[]{-1,-1};
        ans = validateBinaryTreeNodes(2, leftChild, rightChild);
        leftChild = new int[]{1,-1,-1,4,-1,-1};
        rightChild = new int[]{2,-1,-1,5,-1,-1};
        ans = validateBinaryTreeNodes(6, leftChild, rightChild);
        leftChild = new int[]{1, 0, 3, -1};
        rightChild = new int[]{-1, -1, -1, -1};
        ans = validateBinaryTreeNodes(4, leftChild, rightChild);

    }
}

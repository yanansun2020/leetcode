package tree;

import org.junit.Test;

import java.util.Stack;

/**
 * monotone stack, keep looking for small value
 */
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int val : arr) {
            while (val > stack.peek()) {
                int topEle = stack.pop();
                ans +=  topEle * Math.min(stack.peek(), val);
            }
            stack.push(val);
        }
        while (stack.size() > 2) {
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }
    @Test
    public void test(){
        int[] arr = new int[]{6,2,4};
        int ans = mctFromLeafValues(arr);
    }
}

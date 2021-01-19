package oa.c3ai;

import java.util.Arrays;
import java.util.Stack;

/**
 * monotone stack
 */
public class ContiguousarraySize {
    public static void main(String[] args) {
        int[] input = new int[]{7,3,4,6,9,1,5,6,3,7,4,8,2,10};
        int n = input.length;
        Stack<Integer> stack = new Stack<>();

        int[] output = new int[n];
        for(int i=0;i<n;i++){
            int val = input[i];
            while(!stack.isEmpty() && input[stack.peek()]<val) {
                stack.pop();
            }
            if(stack.isEmpty()){
                output[i] = i+1;
            } else {
                output[i] = i-stack.peek();
            }
            stack.add(i);
        }
        System.out.println(Arrays.toString(output));
    }
}

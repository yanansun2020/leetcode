package oa.c3ai;

import org.junit.Test;

import java.util.Stack;

public class LongestConArray {
    int[] getLongestConArray(int[] array){
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[array.length];
        for (int i = 0; i < array.length; i++){
            if (stack.isEmpty() || (!stack.isEmpty() && stack.peek()[0] > array[i])) {
                stack.push(new int[]{array[i], i});
                ans[i] = 1;
                continue;
            }
            int[] topEle = null;
            while(!stack.isEmpty() && stack.peek()[0] < array[i]){
                topEle = stack.pop();
            }
            if (topEle != null) {
                stack.push(new int[]{array[i], topEle[1]});
                ans[i] = i - topEle[1] + 1;
            } else {
                ans[i] = 1;
            }

        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = new int[]{7,3,4, 6, 9, 1, 5, 6, 3, 7, 4, 8, 2, 10};
        int[] ans = getLongestConArray(nums);
        nums = new int[]{1, 2,3,3};
        ans = getLongestConArray(nums);
    }
}

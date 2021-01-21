package oa.amazon.ftoa;

import org.junit.Test;

import java.util.Stack;

/**
 * time O(n)
 * space O(n)
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            if (stack.peek() < 0) {
                stack.push(asteroid);
                continue;
            }
            while (!stack.isEmpty() &&stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty() && Math.abs(asteroid) == stack.peek()) {
                stack.pop();
                continue;
            }
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }
        return ans;
    }
    @Test
    public void test(){
        int[] nums = new int[]{8, -8};
        int[] ans = asteroidCollision(nums);
        nums = new int[]{5, 10, -5};
        ans = asteroidCollision(nums);
        nums = new int[]{10, 2, -5};
        ans = asteroidCollision(nums);
        nums = new int[]{-2, -1, 2, 2};
        ans = asteroidCollision(nums);
    }
}

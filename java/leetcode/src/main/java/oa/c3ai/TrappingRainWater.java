package oa.c3ai;

/**
 * idea: for any cell, the water it can trap = min(max(left), max(right)) - height
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            leftMax[i] = i == 0? height[i] : Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = i == n-1? height[i] : Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}

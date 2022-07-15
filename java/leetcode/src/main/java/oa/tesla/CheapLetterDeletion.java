package oa.tesla;
//You are given a string in which a cost of deletion is assigned to every letter.
// Find the minimum total cost of deletions to achieve a string without two identical letters next to each other. (20 mins)

// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
public class CheapLetterDeletion {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int[] preSum = new int[n + 1];
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < n) {
            char c = colors.charAt(i);
            int maxTime = neededTime[i];
            while (j < n && colors.charAt(j) == c) {
                preSum[j+ 1] = preSum[j] + neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j]);
                j++;
            }
            int sum = preSum[j] - preSum[i];
            res += sum - maxTime;
            i = j;
        }
        return res;
    }
}

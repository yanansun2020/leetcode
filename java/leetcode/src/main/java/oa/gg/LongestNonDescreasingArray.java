package oa.gg;

/**
 * 给出一个int array,  可以将其中的一个int 替换成其它数组中已有的值。 return 替换后最长的continuous non-decreasing subarray
 * [1, 7, 7, 2, 5, 4] 可以将7 换成2 得到的subarray 是[1, 2, 2, 2, 5] 最长
 *
 * not sure the solution
 * but here is a similar question:
 * https://www.geeksforgeeks.org/longest-increasing-subarray-with-one-change-allowed/
 *
 *
 * Step 1: We first compute the longest increasing subarray ending at an index for every index in the given array. We store these values in l[].
 * Step 2: Then calculate the longest increasing subarray starting at an index for every index in the given array. We store these values in r[].
 * Step 3: Update the answer ans = max ( ans, l[i-1] + r[i+1] + 1), when a[i-1] + 1 < a[i+1].
 */
public class LongestNonDescreasingArray {
}

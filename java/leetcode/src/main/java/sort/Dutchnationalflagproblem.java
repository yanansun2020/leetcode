package sort;

/**
 * Leetcode 75 sort color
 * Algorithm
 *
 * Initialise the rightmost boundary of zeros : p0 = 0. During the algorithm execution nums[idx < p0] = 0.
 *
 * Initialise the leftmost boundary of twos : p2 = n - 1. During the algorithm execution nums[idx > p2] = 2.
 *
 * Initialise the index of current element to consider : curr = 0.
 *
 * While curr <= p2 :
 *
 * If nums[curr] = 0 : swap currth and p0th elements and move both pointers to the right.
 *
 * If nums[curr] = 2 : swap currth and p2th elements. Move pointer p2 to the left.
 *
 * If nums[curr] = 1 : move pointer curr to the right.
 */
public class Dutchnationalflagproblem {
    /*
  Dutch National Flag problem solution.
  */
    public void sortColors(int[] nums) {
        // for all idx < i : nums[idx < i] = 0
        // j is an index of element under consideration
        int p0 = 0, curr = 0;
        // for all idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // swap p0-th and curr-th elements
                // i++ and j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // swap k-th and curr-th elements
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}

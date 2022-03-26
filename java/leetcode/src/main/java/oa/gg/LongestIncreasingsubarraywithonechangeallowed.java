package oa.gg;

/**
 * Input  : 6
 *          7 2 3 1 5 10
 * Output : 5
 *
 *
 * Step 1: We first compute the longest increasing subarray ending at an index for every index in the given array. We store these values in l[].
 * Step 2: Then calculate the longest increasing subarray starting at an index for every index in the given array. We store these values in r[].
 * Step 3: Update the answer ans = max ( ans, l[i-1] + r[i+1] + 1), when a[i-1] + 1 < a[i+1].
 */
public class LongestIncreasingsubarraywithonechangeallowed {

    // Java program to find longest increasing subarray
// with one change allowed.
    // Function to find length of
    // subsequence
    static int seg(int[] a, int n)
    {
        int[] l = new int[n];
        int[] r = new int[n + 1];
        int ans = 0;

        // calculating the l array.
        l[0] = 1;
        for (int i = 1; i < n; i++)
        {
            if (a[i] > a[i - 1])
            {
                l[i] = l[i - 1] + 1;
                ans = Math.max(ans, l[i]);
            }
            else
                l[i] = 1;
        }
        if (ans != n)
            ++ans;

        // calculating the r array.
        r[n] = 0;
        for (int i = n - 1; i > 0; i--)
        {
            if (a[i - 1] < a[i])
                r[i] = r[i + 1] + 1;
            else
                r[i] = 1;
        }

        // updating the answer.
        for (int i = n - 2; i > 0; i--)
        {
            if (a[i + 1] - a[i - 1] > 1)
                ans = Math.max(ans,
                    l[i - 1] + r[i + 1] + 1);
        }
        return Math.max(ans, r[0]);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] a = { 9, 4, 5, 1, 13 };
        int n = a.length;

        // Function call
        System.out.println(seg(a, n));
    }

// This code is contributed by
// sanjeev2552

}

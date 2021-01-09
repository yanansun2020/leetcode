package greedy;

import org.junit.Test;

import java.util.Arrays;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int[][] arr = new int[B.length][2];
        for (int i = 0; i < B.length; i++) {
            arr[i] = new int[]{B[i], i};
        }
        Arrays.sort(arr, (a, b)-> a[0] - b[0]);
        Arrays.sort(A);
        int[] ans = new int[B.length];
        int j = B.length - 1;
        int k = 0;
        for (int i = 0; i < B.length && k <=j; i++) {
            if (A[i] > arr[k][0]) {
                ans[arr[k][1]] = A[i];
                k++;
            } else {
                ans[arr[j][1]] =  A[i];
                j--;
            }
        }
        return ans;
    }
    @Test
    public void test(){

    }
}

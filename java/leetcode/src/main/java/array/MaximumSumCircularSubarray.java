package array;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular_TLE(int[] A) {
        int max_count = A[0];
        int[] array = new int[A.length];
        for(int i=0; i< A.length; i++){
            array[0] = A[i];
            for(int j =i+1; j < A.length +i; j++){
                int k = j % A.length;
                array[j-i] = Math.max(A[k], A[k] +array[j-i-1]);
                max_count = Math.max(max_count, array[j-i]);

            }
        }
        return max_count;
    }


    public int maxSubarraySumCircular(int[] A) {
        int global_max = A[0];
        int global_min = A[0];
        int curr_max = A[0];
        int curr_min = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            curr_max = Math.max(curr_max + A[i], A[i]);
            curr_min = Math.min(curr_min + A[i], A[i]);
            global_max = Math.max(global_max, curr_max);
            global_min = Math.min(global_min, curr_min);
            sum += A[i];
        }
        return global_max > 0 ? Math.max(sum - global_min, global_max) : global_max;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray test = new MaximumSumCircularSubarray();
        int[] array = {1,-2,3,-2};
        System.out.println(test.maxSubarraySumCircular(array));
    }
}

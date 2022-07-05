package oa.ms;

public class ParticleVelocity {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] ap = new int[n];
        int last;
        int d = Integer.MIN_VALUE;
        boolean init;
        for (int i = 0; i < n; i++) {
            int count = 1;
            init = false;
            for (int j = i + 1; j < n; j++) {
                if (!init) {
                    d = nums[j] - nums[j - 1];
                    init = true;
                    count++;
                } else if (nums[j] - nums[j - 1] == d) {
                    count++;
                } else {
                    break;
                }
            }
            ap[i] = count;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (ap[i] >= 3) {
                sum = sum + (ap[i] - 2);
            }
        }
        return sum;
    }
}

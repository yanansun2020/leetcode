package string;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] tmp = new int[3];
        for (int i = 0; i < 3; i++) {
            tmp[i] = nums[i];
        }
        boolean validPattern = validatePattern(tmp);
        if (validPattern) {
            return true;
        }
        for (int i = 3; i < nums.length; i++) {
            tmp[0] = tmp[1];
            tmp[1] = tmp[2];
            tmp[2] = nums[i];
            if (validatePattern(tmp)) {
                return true;
            }
        }
        return false;
    }

    private boolean validatePattern(int[] tmp) {
        if (tmp[0] < tmp[2] && tmp[2] < tmp[1]) {
            return true;
        }
        return false;
    }
}

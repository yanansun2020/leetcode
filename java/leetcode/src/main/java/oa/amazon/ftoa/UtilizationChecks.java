package oa.amazon.ftoa;

import org.junit.Test;

public class UtilizationChecks {
    public int finalInstances(int instances, int[] averageUtil) {
        int curInstance = instances;
        for (int i = 0; i < averageUtil.length; i++) {
            if (averageUtil[i] < 25) {
                if (curInstance >= 2) {
                    curInstance = curInstance % 2 == 0 ? curInstance/2: curInstance/2 + 1;
                    i += 10;
                }
            } else if (averageUtil[i] > 60){
                if(curInstance <= 1e8) {
                    curInstance *= 2;
                    i += 10;
                }
            }
        }
        return curInstance;
    }
    @Test
    public void test(){
        int[] nums = new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80};
        int ans = finalInstances(2, nums);
        nums = new int[]{30,5,4,8,19,89};
        ans = finalInstances(5, nums);
    }
}

package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        String largestNumberStr = new String();
        for (String numAsStr : strArr) {
            largestNumberStr += numAsStr;
        }
        if (strArr[0].equals("0")) {
            return "0";
        }
        return largestNumberStr;
    }

    @Test
    public void test(){
        int[] nums = new int[]{10,2};
        String ans = largestNumber(nums);
    }
}

package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=AFtXLUn_TZg
 * (1) find value
 * (2) move value to the first element by reverse
 * (3) move value to the last element by reverse
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        int value = arr.length;
        List<Integer> ans = new ArrayList<>();
        while (value >=1 ) {
            int index = findTheValue(value, arr);
            if (index != 0) {
                ans.add(index+1);
                reverse(0, index, arr);
            }
            if (value != 1){
                ans.add(value);
                reverse(0, value - 1, arr);
            }
            value--;
        }
        return ans;
    }
    private void reverse(int start, int end, int[] arr){
        while (start < end){
            int tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;
            start++;
            end--;
        }
    }
    private int findTheValue(int value, int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[] arr = new int[]{3,2,4,1};
        List<Integer> ans = pancakeSort(arr);
    }
}

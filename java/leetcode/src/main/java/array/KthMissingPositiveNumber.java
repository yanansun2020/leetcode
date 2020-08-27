package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        Integer[] a = {1};
//        List<Integer> s = Arrays.asList(a);
        List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int i = 1;
        while(k >0){
            if(!lst.contains(i)){
                k--;
                if(k == 0){
                    break;
                }
            }
            i++;
        }
        return i;
    }
}

package oa.amazon;

import java.util.HashSet;
import java.util.Set;

public class CheckPairSum {
    boolean check(int row, int cols, int[][] arr, int sum){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< row; i++){
            for(int j =0; j < cols; j++){
                if(set.contains(sum-arr[i][j])){
                    return true;
                }
                set.add(arr[i][j]);
            }
        }
        return false;
    }
}

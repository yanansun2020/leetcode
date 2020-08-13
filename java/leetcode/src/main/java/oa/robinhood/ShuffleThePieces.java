package oa.robinhood;

import java.util.HashMap;
import java.util.Map;

public class ShuffleThePieces {
    public boolean canConcate(int[] arr, int[][] s){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< arr.length; i++){
            map.put(arr[i], i);
        }
        int[] tmp = new int[arr.length];
        for(int i =0; i< s.length; i++){
            Integer index = map.get(s[i][0]);
            if (index == null){
                continue;
            }
            tmp[index] = 1;
            for (int j =1; j<s[i].length; j++){
                Integer curIndex = map.get(s[i][j]);
                if(curIndex == null){break;}
                if(curIndex == index + 1){
                    tmp[curIndex] = 1;
                    index = curIndex;
                }else{
                    break;
                }
            }
        }
        for(int i = 0; i< tmp.length; i++){
            if(tmp[i] == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {1,5,3,6,7,9};
        int[][] sub = {{7,9}, {6}, {1,2,3}};
        ShuffleThePieces test = new ShuffleThePieces();
        System.out.println(test.canConcate(array, sub));
    }
}

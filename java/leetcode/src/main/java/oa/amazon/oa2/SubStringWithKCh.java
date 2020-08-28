package oa.amazon.oa2;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
//substring with k distance
public class SubStringWithKCh {
    int countKDistanceSubString(String inputString, int num){
        if(inputString== "" || inputString== null||num <=0){
            return 0;
        }
        int count = 0;
        for(int i =0; i<inputString.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j< inputString.length(); j++){
                set.add(inputString.charAt(j));
                if(set.size() == num){
                    count++;
                }
                if(set.size() > num){
                    break;
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        int res = countKDistanceSubString("abcbaa", 3);
    }
}

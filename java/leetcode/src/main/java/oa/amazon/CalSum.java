package oa.amazon;

import org.junit.Test;

public class CalSum {
    int cal(String s){
        String temp = "0";
        int sum = 0;
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                temp += ch;
            }else{
                sum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        return sum + Integer.parseInt(temp);
    }
    @Test
    public void test(){
        int res =cal("s0123b4");
    }
}

package robinhood;

import org.junit.Test;

public class Concatenate {
    String reduceTheNumber(String number, int k) {
        if(number.length() <= k){
            return number;
        }
        String num1 = group(number, k);
        return reduceTheNumber(num1, k);
    }

    String group(String input, int k){
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i =0; i<input.length(); i++){
            if(i > 0 && i%k == 0){
                sb.append(addStrDigit(input.substring(j, i)));
                j = i;
            }
        }
        sb.append(addStrDigit(input.substring(j)));
        return sb.toString();
    }
    String addStrDigit(String digitStr){
        int ans = 0;
        for(int i =0; i<digitStr.length(); i++){
            ans += Integer.parseInt(digitStr.charAt(i)+"");
        }
        return ans+"";
    }
    @Test
    public void test(){
        String ans = reduceTheNumber("1111122222", 3);
        String ans1 = reduceTheNumber("1111122222", 5);
    }
}

package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s == null || s.length() == 0){
            return false;
        }
        Character[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<Character> digitList = Arrays.asList(digit);
        boolean occuranceE = false;
        boolean occuranceDot = false;
        for (int i=0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(ch !='+' && ch!='-' && ch != 'e' && ch != '.' && !digitList.contains(ch)){
                return false;
            }
            if((ch == '+' || ch == '-') ){
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            }
            if( ch== 'e'){
                if (occuranceE){
                    return false;
                }
                if(i==0 || i == s.length() -1){
                    return false;
                }
                if (!digitList.contains(s.charAt(i-1))){
                    if(s.charAt(i-1) != '.'){
                        return false;
                    }
                }
                if (!digitList.contains(s.charAt(i+1))){
                    if (s.charAt(i+1) != '+' && s.charAt(i+1) != '-'){
                        return false;
                    }else{
                        if (i + 2 > s.length() -1 || !digitList.contains(s.charAt(i+2))){
                            return false;
                        }
                    }
                }
                occuranceE = true;
            }
            if(ch == '.'){
                if(i == s.length() -1 && ( i -1 < 0 || !digitList.contains(s.charAt(i-1)))){
                    return false;
                }
                if (occuranceE){
                    return false;
                }
                if (i== 0 && (i+1 >= s.length() || !digitList.contains(s.charAt(i+1)))){
                    return false;
                }
                if(occuranceDot){
                    return false;
                }
                occuranceDot = true;
            }

        }
        return true;
    }
    @Test
    public void test(){
        Assert.assertTrue(isNumber("92e1740e91") == false);
        Assert.assertTrue(isNumber(".") == false);
        Assert.assertTrue(isNumber("3.") == true);
        Assert.assertTrue(isNumber(".1") == true);
        Assert.assertTrue(isNumber("0") == true);
        Assert.assertTrue(isNumber(" 0.1") == true);
        Assert.assertTrue(isNumber("abc") == false);
        Assert.assertTrue(isNumber("1 a") == false);
        Assert.assertTrue(isNumber("2e10") == true);
        Assert.assertTrue(isNumber(" -90e3   ") == true);
        Assert.assertTrue(isNumber(" 1e") == false);
        Assert.assertTrue(isNumber("e3") == false);
        Assert.assertTrue(isNumber(" 6e-1") == true);

        Assert.assertTrue(isNumber("99e2.5 ") == false);
        Assert.assertTrue(isNumber("53.5e93") == true);
        Assert.assertTrue(isNumber(" --6") == false);

        Assert.assertTrue(isNumber("-+3") == false);
        Assert.assertTrue(isNumber("95a54e53") == false);
    }
}
